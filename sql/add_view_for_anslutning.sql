CREATE 
VIEW `grupperade_anslutningar` AS
    SELECT 
        `a`.`id` AS `id`,
        `kall`.`name` AS `kallsystem`,
        `kat`.`name` AS `kategori`,
        `org`.`name` AS `organisatoriskenhet`,
        `tjk`.`name` AS `tjanstekontrakt`,
        `urk`.`name` AS `ursprungligkonsument`,
        `ve`.`name` AS `vardenhet`,
        `vg`.`name` AS `vardgivare`,
        MIN(`a`.`forstaAnslutningsDatum`) AS `forstaAnslutningsDatum`,
        MAX(`a`.`senasteAnslutningsDatum`) AS `senasteAnslutningsDatum`
    FROM
        (((((((`anslutning` `a`
        JOIN `kallsystem` `kall` ON ((`a`.`kallsystem` = `kall`.`id`)))
        JOIN `kategori` `kat` ON ((`a`.`kategori` = `kat`.`id`)))
        JOIN `organisatoriskenhet` `org` ON ((`a`.`organisatoriskenhet` = `org`.`id`)))
        JOIN `tjanstekontrakt` `tjk` ON ((`a`.`tjanstekontrakt` = `tjk`.`id`)))
        JOIN `ursprungligkonsument` `urk` ON ((`a`.`ursprungligkonsument` = `urk`.`id`)))
        JOIN `vardenhet` `ve` ON ((`a`.`vardenhet` = `ve`.`id`)))
        JOIN `vardgivare` `vg` ON ((`a`.`vardgivare` = `vg`.`id`)))
    GROUP BY `kall`.`name` , `kat`.`name` , `org`.`name` , `tjk`.`name` , `urk`.`name` , `ve`.`name` , `vg`.`name`