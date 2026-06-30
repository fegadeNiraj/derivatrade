-- =====================================================
-- Version     : V2
-- Description : Create market_makers table
-- Author      : Niraj Fegade
-- =====================================================


CREATE TABLE market_makers
(
    id UUID PRIMARY KEY,

    code VARCHAR(20) NOT NULL UNIQUE,

    name VARCHAR(100) NOT NULL UNIQUE,

    status VARCHAR(20) NOT NULL,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL
);