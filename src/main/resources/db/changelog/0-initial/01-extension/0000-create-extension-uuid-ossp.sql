--liquibase formatted sql
--changeset d.losev:1740210470

create
extension if not exists "uuid-ossp" schema extension;