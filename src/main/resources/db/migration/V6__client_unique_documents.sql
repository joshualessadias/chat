
ALTER TABLE client
    ADD CONSTRAINT uc_client_cnpj UNIQUE (cnpj);

ALTER TABLE client
    ADD CONSTRAINT uc_client_cpf UNIQUE (cpf);