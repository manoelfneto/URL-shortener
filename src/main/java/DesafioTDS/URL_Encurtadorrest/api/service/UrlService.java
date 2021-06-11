package DesafioTDS.URL_Encurtadorrest.api.service;

import DesafioTDS.URL_Encurtadorrest.api.model.Url;
import DesafioTDS.URL_Encurtadorrest.api.model.UrlDto;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {

    public Url generateShortLink(UrlDto urlDto);
    public Url persistShortLink(Url url);
    public Url getEncodedUrl(String url);
    public void deleteShortLink(Url url);
}
