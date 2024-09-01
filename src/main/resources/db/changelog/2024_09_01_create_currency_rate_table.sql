--liquibase formatted sql

--changeset sakhulbay:1
CREATE TABLE t_currency_rate
(
    id                  SERIAL PRIMARY KEY,
    currency_short_name CHAR(3)          NOT NULL UNIQUE,
    rate_to_usd         DOUBLE PRECISION NOT NULL,
    date_time           TIMESTAMP        NOT NULL
);
