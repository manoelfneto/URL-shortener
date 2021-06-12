package DesafioTDS.URL_Encurtadorrest.api.controller;

import DesafioTDS.URL_Encurtadorrest.api.model.UrlErrorResponseDto;
import DesafioTDS.URL_Encurtadorrest.api.model.UrlResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class UrlShorteningControllerTest {

    @Test
    void generateShortLink() {
        UrlResponseDto urlResponseDto = new UrlResponseDto();
        urlResponseDto.setLinkOriginal("google.com");
        urlResponseDto.setLinkCurto("linkcurto");
        assertEquals("linkcurto", urlResponseDto.getLinkCurto());
        assertEquals("google.com", urlResponseDto.getLinkOriginal());

    }

    @Test
    void redirectToOriginalUrl() {
        UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
        urlErrorResponseDto.setError("url invalida");
        urlErrorResponseDto.setStatus("400");

        assertEquals("url invalida", urlErrorResponseDto.getError());
        assertEquals("400", urlErrorResponseDto.getStatus());

    }
}