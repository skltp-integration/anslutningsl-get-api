package se.skltp.anslutningslagetApi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import se.skltp.anslutningslagetApi.models.entity.Anslutning;
import se.skltp.anslutningslagetApi.repository.AnslutningRepository;
import se.skltp.anslutningslagetApi.service.AnslutningService;

import java.util.LinkedList;
import java.util.List;

@Service
public class AnslutningServiceImpl extends SpecificationBuilder<Anslutning, AnslutningCriteria> implements AnslutningService {

    @Autowired
    protected AnslutningRepository anslutningRepository;

    public List<Anslutning> findAll(AnslutningCriteria criteria, Pageable pageRequest) {
        if (criteria.isEmpty()) {
            return anslutningRepository.findAll(pageRequest).getContent();
        } else {
            Specification<Anslutning> specification = buildSpecification(criteria);
            return anslutningRepository.findAll(specification, pageRequest).getContent();
        }
    }


    @Override
    protected void addSpecifactionsToQuery(LinkedList<Specification<Anslutning>> specifications, AnslutningCriteria criteria) {
        if (criteria.getKategori() != null) {
            specifications.add(like("kategori", criteria.getKategori()));
        }
        if (criteria.getVardgivare() != null) {
            specifications.add(like("vardgivare", criteria.getVardgivare()));
        }
        if (criteria.getVardenhet() != null) {
            specifications.add(like("vardenhet", criteria.getVardenhet()));
        }
        if (criteria.getUrsprungligkonsument() != null) {
            specifications.add(like("ursprungligkonsument", criteria.getUrsprungligkonsument()));
        }
        if (criteria.getTjanstekontrakt() != null) {
            specifications.add(like("tjanstekontrakt", criteria.getTjanstekontrakt()));
        }
        if (criteria.getOrganisatoriskenhet() != null) {
            specifications.add(like("organisatoriskenhet", criteria.getOrganisatoriskenhet()));
        }
        if (criteria.getKallsystem() != null) {
            specifications.add(like("kallsystem", criteria.getKallsystem()));
        }
    }
}
