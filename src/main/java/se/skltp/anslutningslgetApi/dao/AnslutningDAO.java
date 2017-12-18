package se.skltp.anslutningslgetApi.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.skltp.anslutningslgetApi.models.entity.Anslutning;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

@Repository
public class AnslutningDAO {

    @Autowired
    private EntityManager entityManager;



    public List<Anslutning> getAll() {
        return entityManager.createQuery("select a from Anslutning a").getResultList();
    }
}

