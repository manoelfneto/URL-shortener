package DesafioTDS.URL_Encurtadorrest.api.service;

import DesafioTDS.URL_Encurtadorrest.api.model.Url;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UrlServiceImplTest {

    @Test
    void generateShortLink() {
        Url urlToPersist = new Url();
        urlToPersist.setLinkOriginal("twitter.com");
        urlToPersist.setLinkCurto("linkcurto");

        assertEquals("twitter.com", urlToPersist.getLinkOriginal());
        assertEquals("linkcurto", urlToPersist.getLinkCurto());
    }
}