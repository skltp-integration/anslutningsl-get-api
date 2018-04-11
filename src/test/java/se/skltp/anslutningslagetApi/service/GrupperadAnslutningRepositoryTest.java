package se.skltp.anslutningslagetApi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.skltp.anslutningslagetApi.models.entity.Anslutning;
import se.skltp.anslutningslagetApi.models.entity.GrupperadAnslutning;
import se.skltp.anslutningslagetApi.repository.AnslutningRepository;
import se.skltp.anslutningslagetApi.repository.GrupperadeAnslutningRepository;

import javax.persistence.criteria.JoinType;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrupperadAnslutningRepositoryTest {

    @Autowired
    private GrupperadeAnslutningRepository grupperadeAnslutningRepository;


    @Autowired
    private AnslutningRepository anslutningRepository;


    private String[] grupperadFields =  {"kallsystem","kategori","organisatoriskenhet", "tjanstekontrakt", "ursprungligkonsument", "vardenhet", "vardgivare"};

    @Test
    public void testGrupperingDubbletter() throws Exception {
        List<Anslutning> anslutnings = anslutningRepository.findAll();
        assertEquals(20, anslutnings.size());

        List<GrupperadAnslutning> grupperadAnslutnings = grupperadeAnslutningRepository.findAll();
        assertEquals(anslutnings.size() - 7, grupperadAnslutnings.size());
    }

    @Test
    public void testDubbletterDates() {

        for(String filed: grupperadFields) {

            List<Anslutning> anslutningar = anslutningRepository.findAll((root, query, cb) -> cb.equal(root.join(filed, JoinType.LEFT).get("name"), "dubblicate"));
            assertEquals(2, anslutningar.size());

            Date minDate = anslutningar.get(0).getForstaAnslutningsDatum();
            Date maxDate = anslutningar.get(0).getSenasteAnslutningsDatum();

            for (Anslutning currentAnslutning : anslutningar) {
                minDate = currentAnslutning.getForstaAnslutningsDatum().before(minDate) ? currentAnslutning.getForstaAnslutningsDatum() : minDate;
                maxDate = currentAnslutning.getSenasteAnslutningsDatum().after(maxDate) ? currentAnslutning.getSenasteAnslutningsDatum() : maxDate;
            }

            List<GrupperadAnslutning> grupperadeAnslutningar = grupperadeAnslutningRepository.findAll((root, query, cb) -> cb.equal(root.get(filed), "dubblicate"));
            assertEquals(1, grupperadeAnslutningar.size());

            assertEquals(minDate, grupperadeAnslutningar.get(0).getForstaAnslutningsDatum());
            assertEquals(maxDate, grupperadeAnslutningar.get(0).getSenasteAnslutningsDatum());
        }
    }
}

