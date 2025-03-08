--liquibase formatted sql
--changeset d.losev:1740210470

set
search_path to kateteria;

create sequence cake_id_seq increment by 50;

create table cake
(
    id          bigint        not null primary key default nextval('cake_id_seq'),
    uuid        uuid          not null             default extension.uuid_generate_v4(),
    title       varchar(127)  not null,
    description varchar(1023) not null,
    cost        int           not null
);

alter sequence cake_id_seq owned by cake.id;