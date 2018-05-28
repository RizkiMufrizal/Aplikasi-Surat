CREATE TABLE tb_user (
    username VARCHAR(50) NOT NULL,
    is_active BIT(1) NOT NULL,
    password VARCHAR(100) NOT NULL,
    position VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)  ENGINE=INNODB;

CREATE TABLE tb_user_role (
    id_user_role VARCHAR(36) NOT NULL,
    role VARCHAR(15) NOT NULL,
    username VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=INNODB;

CREATE TABLE tb_letter (
    id_letter VARCHAR(36) NOT NULL,
    subject VARCHAR(30) NOT NULL,
    agenda_number VARCHAR(30) NOT NULL,
    letter_number VARCHAR(30) NOT NULL,
    agenda_date TIMESTAMP NOT NULL,
    description VARCHAR(30) NOT NULL,
    is_let_pass BIT(1) NOT NULL,
    letter_upload VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=INNODB;

CREATE TABLE tb_disposition (
    id_disposition VARCHAR(36) NOT NULL,
    disposition_date TIMESTAMP NOT NULL,
    disposition_to VARCHAR(30) NOT NULL,
    is_disposition BIT(1) NOT NULL,
    id_letter VARCHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=INNODB;

ALTER TABLE tb_user
  ADD PRIMARY KEY (username);

ALTER TABLE tb_user_role
  ADD PRIMARY KEY (id_user_role),
  ADD KEY fk_username (username);

ALTER TABLE tb_letter
  ADD PRIMARY KEY (id_letter);

ALTER TABLE tb_disposition
  ADD PRIMARY KEY (id_disposition),
  ADD KEY fk_id_letter (id_letter);

ALTER TABLE tb_user_role
ADD CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES tb_user (username);

ALTER TABLE tb_disposition
ADD CONSTRAINT fk_id_letter FOREIGN KEY (id_letter) REFERENCES tb_letter (id_letter);