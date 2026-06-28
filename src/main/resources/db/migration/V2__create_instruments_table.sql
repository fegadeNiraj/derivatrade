-- =====================================================
-- Version     : V2
-- Description : Create instruments table
-- Author      : Niraj Fegade
-- =====================================================

CREATE TABLE instruments
(
    id UUID PRIMARY KEY,

    symbol VARCHAR(20) NOT NULL UNIQUE,

    name VARCHAR(100) NOT NULL,

    exchange VARCHAR(20) NOT NULL,

    currency VARCHAR(3) NOT NULL,

    tick_size NUMERIC(10,4) NOT NULL,

    status VARCHAR(20) NOT NULL,

    asset_class VARCHAR(20) NOT NULL,

    instrument_type VARCHAR(20) NOT NULL,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL
);