package se.skltp.anslutningslagetApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import se.skltp.anslutningslagetApi.models.entity.Anslutning;

public interface AnslutningRepository extends JpaRepository<Anslutning, Integer>, JpaSpecificationExecutor<Anslutning> {

}
