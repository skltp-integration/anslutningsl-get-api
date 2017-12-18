package se.skltp.anslutningslgetApi.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "anslutning")
public class Anslutning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
