package DesafioTDS.URL_Encurtadorrest.api.service;

import DesafioTDS.URL_Encurtadorrest.api.Repository.UrlRepository;
import DesafioTDS.URL_Encurtadorrest.api.model.Url;
import DesafioTDS.URL_Encurtadorrest.api.model.UrlDto;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class UrlServiceImpl implements UrlService{

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public Url generateShortLink(UrlDto urlDto) {

        if (StringUtils.isNotEmpty(urlDto.getUrl())){
            String encodedUrl = encodeUrl(urlDto.getUrl());
            Url urlToPersist = new Url();
            urlToPersist.setDataCriacao(LocalDateTime.now());
            urlToPersist.setLinkOriginal((urlDto.getUrl()));
            urlToPersist.setLinkCurto(encodedUrl);
            Url urlToRet = persistShortLink(urlToPersist);

            if (urlToRet != null) {
                return urlToRet;
            }
        }
        return null;
    }

    private String encodeUrl(String url) {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32().hashString(url.concat(time.toString()), StandardCharsets.UTF_8).toString();

        return encodedUrl;
    }

    @Override
    public Url persistShortLink(Url url) {
        Url urlToRet =  urlRepository.save(url);
        return urlToRet;
    }

    @Override
    public Url getEncodedUrl(String url) {
        Url urlToRet = urlRepository.findByLinkCurto(url);
        return urlToRet;
    }

    @Override
    public void deleteShortLink(Url url) {
        urlRepository.delete(url);

    }
}
