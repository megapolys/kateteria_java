--liquibase formatted sql
--changeset d.losev:1740210470

set
search_path to kateteria;

create table password
(
    pass_hash varchar(1023) not null
);