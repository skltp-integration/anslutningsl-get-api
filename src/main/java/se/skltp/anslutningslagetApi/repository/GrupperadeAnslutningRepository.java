package se.skltp.anslutningslagetApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import se.skltp.anslutningslagetApi.models.entity.Anslutning;
import se.skltp.anslutningslagetApi.models.entity.GrupperadAnslutning;

public interface GrupperadeAnslutningRepository extends JpaRepository<GrupperadAnslutning, Integer>, JpaSpecificationExecutor<GrupperadAnslutning> {
}
