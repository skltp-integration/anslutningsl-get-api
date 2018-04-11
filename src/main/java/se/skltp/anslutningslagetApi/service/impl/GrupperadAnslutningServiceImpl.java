package se.skltp.anslutningslagetApi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import se.skltp.anslutningslagetApi.models.entity.GrupperadAnslutning;
import se.skltp.anslutningslagetApi.repository.GrupperadeAnslutningRepository;
import se.skltp.anslutningslagetApi.service.GrupperadAnslutningService;

import java.util.LinkedList;
import java.util.List;

@Service
public class GrupperadAnslutningServiceImpl extends SpecificationBuilder<GrupperadAnslutning, AnslutningCriteria> implements GrupperadAnslutningService {

    @Autowired
    GrupperadeAnslutningRepository anslutningRepository;

    @Override
    public List<GrupperadAnslutning> findAll(AnslutningCriteria criteria, Pageable pageRequest) {
        if (criteria.isEmpty()) {
            return anslutningRepository.findAll(pageRequest).getContent();
        } else {
            Specification<GrupperadAnslutning> specification = buildSpecification(criteria);
            return anslutningRepository.findAll(specification, pageRequest).getContent();
        }
    }

    @Override
    protected void addSpecifactionsToQuery(LinkedList<Specification<GrupperadAnslutning>> specifications, AnslutningCriteria criteria) {
        if (criteria.getKategori() != null) {
            specifications.add(likeString("kategori", criteria.getKategori()));
        }
        if (criteria.getVardgivare() != null) {
            specifications.add(likeString("vardgivare", criteria.getVardgivare()));
        }
        if (criteria.getVardenhet() != null) {
            specifications.add(likeString("vardenhet", criteria.getVardenhet()));
        }
        if (criteria.getUrsprungligkonsument() != null) {
            specifications.add(likeString("ursprungligkonsument", criteria.getUrsprungligkonsument()));
        }
        if (criteria.getTjanstekontrakt() != null) {
            specifications.add(likeString("tjanstekontrakt", criteria.getTjanstekontrakt()));
        }
        if (criteria.getOrganisatoriskenhet() != null) {
            specifications.add(likeString("organisatoriskenhet", criteria.getOrganisatoriskenhet()));
        }
        if (criteria.getKallsystem() != null) {
            specifications.add(likeString("kallsystem", criteria.getKallsystem()));
        }

        if(criteria.getForstaAnslutningsInterval() != null){
            specifications.add(mellanDates("forstaAnslutningsDatum", criteria.getForstaAnslutningsInterval().getFirst(), criteria.getForstaAnslutningsInterval().getSecond()));
        }

        if(criteria.getSenasteAnslutningsInterval() != null){
            specifications.add(mellanDates("senasteAnslutningsDatum", criteria.getSenasteAnslutningsInterval().getFirst(), criteria.getSenasteAnslutningsInterval().getSecond()));
        }
    }
}
