CREATE TABLE patients (
      id bigint not null auto_increment,
      name VARCHAR(255) not null,
      email VARCHAR(255) not null unique,
      cpf VARCHAR(14) not null unique,
      telephone varchar(20) not null,
      thoroughfare VARCHAR(255) not null,
      neighborhood VARCHAR(255) not null,
      zip_code VARCHAR(10) not null,
      city VARCHAR(255) not null,
      state VARCHAR(255) not null,
      complement VARCHAR(255),
      number VARCHAR(10),
      primary key(id)
);
