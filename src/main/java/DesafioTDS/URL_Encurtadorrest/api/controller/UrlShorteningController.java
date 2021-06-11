package DesafioTDS.URL_Encurtadorrest.api.controller;


import DesafioTDS.URL_Encurtadorrest.api.model.Url;
import DesafioTDS.URL_Encurtadorrest.api.model.UrlDto;
import DesafioTDS.URL_Encurtadorrest.api.model.UrlErrorResponseDto;
import DesafioTDS.URL_Encurtadorrest.api.model.UrlResponseDto;
import DesafioTDS.URL_Encurtadorrest.api.service.UrlService;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UrlShorteningController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateShortLink(@RequestBody UrlDto urlDto){

        Url urlToRet = urlService.generateShortLink(urlDto);

        if(urlToRet != null){
            UrlResponseDto urlResponseDto = new UrlResponseDto();
            urlResponseDto.setLinkOriginal(urlToRet.getLinkOriginal());
            urlResponseDto.setLinkCurto(urlToRet.getLinkCurto());

            return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);
        }

        UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
        urlErrorResponseDto.setStatus("404");
        urlErrorResponseDto.setError("Erro, tente de novo");
        return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK);

    }
    @GetMapping("/{linkcurto}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String linkcurto, HttpServletResponse response) throws IOException {

        if(StringUtils.isEmpty(linkcurto)){
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setError("url invalida");
            urlErrorResponseDto.setStatus("400");
            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK);
        }
        Url urlToRet =  urlService.getEncodedUrl(linkcurto);

        if(urlToRet == null){
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setError("url nao existe");
            urlErrorResponseDto.setStatus("400");
            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK);
        }

        response.sendRedirect(urlToRet.getLinkOriginal());
        return null;

    }
}
