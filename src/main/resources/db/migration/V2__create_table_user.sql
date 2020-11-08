-- Creation table des utilisateurs

CREATE TABLE user (
  id BIGINT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL

);
ALTER TABLE user ADD CONSTRAINT user_username_unique UNIQUE (username);
CREATE SEQUENCE seq_user START 0;