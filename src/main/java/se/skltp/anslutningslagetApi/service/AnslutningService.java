package se.skltp.anslutningslagetApi.service;

import org.springframework.data.domain.Pageable;
import se.skltp.anslutningslagetApi.models.entity.Anslutning;
import se.skltp.anslutningslagetApi.service.impl.AnslutningCriteria;

import java.util.List;

public interface AnslutningService {
    List<Anslutning> findAll(AnslutningCriteria criteria, Pageable pageRequest);
}
