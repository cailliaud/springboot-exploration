-- Creation de la table des champions

CREATE TABLE champion (
    id BIGINT PRIMARY KEY,
    reference VARCHAR(50) NOT NULL,
    name VARCHAR(255) NOT NULL

);
ALTER TABLE champion ADD CONSTRAINT champion_name_unique UNIQUE (name);
ALTER TABLE champion ADD CONSTRAINT champion_reference_unique UNIQUE (reference);
CREATE SEQUENCE seq_champion START 0;