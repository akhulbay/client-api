--liquibase formatted sql

--changeset sakhulbay:1
CREATE TABLE t_account
(
    id         BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL
);

--changeset sakhulbay:2
CREATE TABLE t_account_limit
(
    id                  BIGINT PRIMARY KEY,
    sum                 DOUBLE PRECISION NOT NULL,
    date_time           TIMESTAMP        NOT NULL,
    currency_short_name CHAR(3)          NOT NULL
);

--changeset sakhulbay:3
CREATE TABLE t_transaction
(
    id                  BIGSERIAL PRIMARY KEY,
    created_at          TIMESTAMP        NOT NULL,
    sum                 DOUBLE PRECISION NOT NULL,
    currency_short_name CHAR(3)          NOT NULL,
    category            VARCHAR(32)      NOT NULL,
    limit_exceeded      BOOLEAN          NOT NULL,
    account_from        BIGINT REFERENCES t_account (id),
    account_to          BIGINT REFERENCES t_account (id)
)