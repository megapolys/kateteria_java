--liquibase formatted sql
--changeset d.losev:1740210470

set
search_path to kateteria;

create sequence cake_group_id_seq increment by 50;

create table cake_group
(
    id   bigint       not null primary key default nextval('cake_group_id_seq'),
    name varchar(127) not null
);

alter sequence cake_group_id_seq owned by cake_group.id;