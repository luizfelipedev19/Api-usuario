CREATE TABLE users(
      id SERIAL PRIMARY KEY,
      nome VARCHAR (100) NOT NULL,
      email VARCHAR (100) NOT NULL UNIQUE ,
      password VARCHAR (12) NOT NULL,
      role VARCHAR(10) NOT NULL
);
