package DesafioTDS.URL_Encurtadorrest.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Url {

    @Id
    @GeneratedValue
    private long id;

    @Lob
    private String linkOriginal;
    private String linkCurto;
    private LocalDateTime dataCriacao;

    public Url(long id, String linkOriginal, String linkCurto, LocalDateTime dataCriacao) {
        this.id = id;
        this.linkOriginal = linkOriginal;
        this.linkCurto = linkCurto;
        this.dataCriacao = dataCriacao;
    }

    public Url() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", linkOriginal='" + linkOriginal + '\'' +
                ", linkCurto='" + linkCurto + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

}
