--liquibase formatted sql
--changeset d.losev:1740210470

set
search_path to kateteria;

alter table cake
    add column if not exists group_id bigint not null references cake_group(id);