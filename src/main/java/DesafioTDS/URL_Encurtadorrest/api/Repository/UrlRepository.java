package DesafioTDS.URL_Encurtadorrest.api.Repository;

import DesafioTDS.URL_Encurtadorrest.api.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    public Url findByLinkCurto(String linkCurto);
}
