CREATE DATABASE Pais;
USE Pais;
CREATE TABLE Paises (
	id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    area_total NUMERIC (15,2) NOT NULL,
    populacao BIGINT NOT NULL
  )

