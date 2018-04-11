INSERT INTO `kallsystem` VALUES (1, 'dubblicate'), (2, 'dubblicate'), (3,'SE2321000164-9999'),(4,'SE2321000164-9994');
INSERT INTO `kategori` VALUES (1, 'dubblicate'), (2, 'dubblicate'), (3,'1'),(4,'2');
INSERT INTO `organisatoriskenhet` VALUES (1, 'dubblicate'), (2, 'dubblicate'), (3,'SE2321000164-1111111111111'),(4,'SE2321000164-1111111111114');
INSERT INTO `tjanstekontrakt` VALUES (1, 'dubblicate'), (2, 'dubblicate'), (3,'urn:riv:clinicalprocess:healthcond:description:GetCareDocumentationResponder:2'),(4,'urn:riv:clinicalprocess:healthcond:description:GetFunctionalStatusResponder:2');
INSERT INTO `ursprungligkonsument` VALUES (1, 'dubblicate'), (2, 'dubblicate'), (3,'T_SERVICES_SE165565594230-6666'),(4,'T_SERVICES_SE165565594230-5555');
INSERT INTO `vardenhet` VALUES (1, 'dubblicate'), (2, 'dubblicate'), (3,'SE2321000164-123'),(4,'SE2321000164-345');
INSERT INTO `vardgivare` VALUES (1, 'dubblicate'), (2, 'dubblicate'), (3,'SE2321000164-1234567891033'),(4,'SE2321000164-0000000000003');

INSERT INTO `anslutning`(id, kallsystem, kategori, forstaAnslutningsDatum, organisatoriskenhet, tjanstekontrakt, ursprungligkonsument, vardenhet, vardgivare, senasteAnslutningsDatum) VALUES
-- dubbleter i kallsystem
(1,1,4,'2013-12-13 15:00:00',3,4,3,4,3,'2018-02-01 20:00:00'), --1
(2,2,4,'2017-12-13 14:00:00',3,4,3,4,3,'2018-02-01 21:00:00'),

-- dubbleter i kategori
(3,3,1,'2013-12-13 15:00:00',3,4,3,4,3,'2018-02-01 20:00:00'), --2
(4,3,2,'2017-12-13 14:00:00',3,4,3,4,3,'2018-02-01 21:00:00'),

-- dubbleter i organisatoriskenhet
(5,3,4,'2017-12-13 15:00:00',1,4,3,4,3,'2018-02-01 20:00:00'), --3
(6,3,4,'2017-12-13 16:00:00',2,4,3,4,3,'2018-02-01 21:00:00'),

--dubbletter i tjanstekontrakt
(7,3,4,'2017-12-13 15:14:16',3,1,3,4,3,'2018-02-01 20:42:52'), --4
(8,3,4,'2017-12-13 15:14:16',3,2,3,4,3,'2018-02-01 20:43:21'),

--dubbletter i ursprungligkonsument
 (9,3,4,'2013-12-13 15:00:00',3,4,1,4,3,'2018-02-01 20:00:00'), --5
(10,3,4,'2017-12-13 14:00:00',3,4,2,4,3,'2018-02-01 21:00:00'),

--dubbletter i vardenhet
(11,3,4,'2013-12-13 15:00:00',3,4,3,1,3,'2018-02-01 20:00:00'), --6
(12,3,4,'2017-12-13 14:00:00',3,4,3,2,3,'2018-02-01 21:00:00'),

--dubbletter i VARDGIVARE
(13,3,4,'2013-12-13 15:00:00',3,4,3,4,1,'2018-02-01 20:00:00'), --7
(14,3,4,'2017-12-13 14:00:00',3,4,3,4,2,'2018-02-01 21:00:00'),


(15,3,4,'2017-12-13 15:14:16',3,3,3,3,3,'2018-02-01 20:43:21'), --8
(16,3,4,'2017-12-13 15:14:16',4,4,4,4,4,'2018-02-01 20:43:29'), --9
(17,3,4,'2017-12-13 15:14:16',3,4,4,4,4,'2017-12-13 15:14:16'), --10
(18,3,4,'2018-12-13 15:14:16',3,3,4,4,4,'2018-02-01 20:43:24'), --11
(19,3,4,'2018-02-01 20:39:33',3,3,3,4,4,'2018-02-01 20:39:33'), --12
(20,3,4,'2018-02-01 20:39:33',3,3,3,3,4,'2018-02-01 20:42:42'); --13

