package DesafioTDS.URL_Encurtadorrest.api.model;

public class UrlResponseDto {

    private String linkOriginal;
    private String linkCurto;

    public UrlResponseDto(String linkOriginal, String linkCurto) {
        this.linkOriginal = linkOriginal;
        this.linkCurto = linkCurto;
    }

    public UrlResponseDto() {
    }

    public String getLinkOriginal() {
        return linkOriginal;
    }

    public void setLinkOriginal(String linkOriginal) {
        this.linkOriginal = linkOriginal;
    }

    public String getLinkCurto() {
        return linkCurto;
    }

    public void setLinkCurto(String linkCurto) {
        this.linkCurto = linkCurto;
    }

    @Override
    public String toString() {
        return "UrlResponseDto{" +
                "linkOriginal='" + linkOriginal + '\'' +
                ", linkCurto='" + linkCurto + '\'' +
                '}';
    }
}
