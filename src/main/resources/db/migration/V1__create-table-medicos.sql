CREATE TABLE medical (
      id bigint not null auto_increment,
      name VARCHAR(255) not null,
      email VARCHAR(255) not null unique,
      crm VARCHAR(50) not null unique,
      specialty VARCHAR(100) not null,
      thoroughfare VARCHAR(255) not null,
      neighborhood VARCHAR(255) not null,
      zip_code VARCHAR(10) not null,
      city VARCHAR(255) not null,
      state VARCHAR(255) not null,
      complement VARCHAR(255),
      number VARCHAR(10),
      primary key(id)
);
