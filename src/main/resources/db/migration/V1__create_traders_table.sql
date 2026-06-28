-- =====================================================
-- Version     : V1
-- Description : Create traders table
-- Author      : Niraj Fegade
-- =====================================================
CREATE SEQUENCE trader_account_number_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE traders
(
    id UUID NOT NULL,

    full_name VARCHAR(100) NOT NULL,

    email VARCHAR(100) NOT NULL,

    contact_number VARCHAR(10) NOT NULL,

    trading_account_number VARCHAR(20) NOT NULL,

    status VARCHAR(30) NOT NULL,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL,

    CONSTRAINT pk_traders PRIMARY KEY (id),

    CONSTRAINT uk_traders_email UNIQUE (email),

    CONSTRAINT uk_traders_contact_number UNIQUE (contact_number),

    CONSTRAINT uk_traders_account_number UNIQUE (trading_account_number)
);