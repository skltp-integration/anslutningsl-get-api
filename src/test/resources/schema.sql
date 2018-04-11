CREATE TABLE KALLSYSTEM (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  NAME varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE KATEGORI (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  NAME varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE ORGANISATORISKENHET (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  NAME varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TJANSTEKONTRAKT (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  NAME varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE URSPRUNGLIGKONSUMENT (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  NAME varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE VARDENHET (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  NAME varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE VARDGIVARE (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  NAME varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE ANSLUTNING (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  KALLSYSTEM bigint(20) NOT NULL,
  KATEGORI bigint(20) NOT NULL,
  forstaAnslutningsDatum datetime DEFAULT NULL,
  ORGANISATORISKENHET bigint(20) NOT NULL,
  TJANSTEKONTRAKT bigint(20) NOT NULL,
  URSPRUNGLIGKONSUMENT bigint(20) NOT NULL,
  VARDENHET bigint(20) NOT NULL,
  VARDGIVARE bigint(20) NOT NULL,
  senasteAnslutningsDatum datetime DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY IDX_ANSLUTNING (VARDGIVARE,VARDENHET,ORGANISATORISKENHET, TJANSTEKONTRAKT, KATEGORI, KALLSYSTEM,URSPRUNGLIGKONSUMENT),
  CONSTRAINT FK_KALLSYSTEM FOREIGN KEY (KALLSYSTEM) REFERENCES KALLSYSTEM (ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_KATEGORI FOREIGN KEY (KATEGORI) REFERENCES KATEGORI (ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_organisatoriskenhet FOREIGN KEY (ORGANISATORISKENHET) REFERENCES ORGANISATORISKENHET (ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_TJANSTEKONTRAKT FOREIGN KEY (TJANSTEKONTRAKT) REFERENCES TJANSTEKONTRAKT (ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_URSPRUNGLIGKONSUMENT FOREIGN KEY (URSPRUNGLIGKONSUMENT) REFERENCES URSPRUNGLIGKONSUMENT (ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_VARDENHET FOREIGN KEY (VARDENHET) REFERENCES VARDENHET (ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_VARDGIVARE FOREIGN KEY (VARDGIVARE) REFERENCES VARDGIVARE (ID) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE VIEW GRUPPERADE_ANSLUTNINGAR AS
    SELECT
        max(A.id) AS id,
        KALL.NAME AS KALLSYSTEM,
        KAT.NAME AS KATEGORI,
        ORG.NAME AS ORGANISATORISKENHET,
        TJK.NAME AS TJANSTEKONTRAKT,
        URK.NAME AS URSPRUNGLIGKONSUMENT,
        VE.NAME AS VARDENHET,
        VG.NAME AS VARDGIVARE,
        MIN(A.`forstaAnslutningsDatum`) AS `forstaAnslutningsDatum`,
        MAX(A.`senasteAnslutningsDatum`) AS `senasteAnslutningsDatum`
    FROM
        (((((((ANSLUTNING A
        JOIN KALLSYSTEM KALL ON ((A.KALLSYSTEM = KALL.ID)))
        JOIN KATEGORI KAT ON ((A.KATEGORI = KAT.ID)))
        JOIN ORGANISATORISKENHET ORG ON ((A.ORGANISATORISKENHET = ORG.ID)))
        JOIN TJANSTEKONTRAKT TJK ON ((A.TJANSTEKONTRAKT = TJK.ID)))
        JOIN URSPRUNGLIGKONSUMENT URK ON ((A.URSPRUNGLIGKONSUMENT = URK.ID)))
        JOIN VARDENHET VE ON ((A.VARDENHET = VE.ID)))
        JOIN VARDGIVARE VG ON ((A.VARDGIVARE = VG.ID)))
    GROUP BY KALL.NAME , KAT.NAME , ORG.NAME , TJK.NAME , URK.NAME , VE.NAME , VG.NAME;