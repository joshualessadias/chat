ALTER TABLE client
    DROP COLUMN cnpj;

ALTER TABLE client
    DROP COLUMN cpf;

ALTER TABLE client
    ADD cnpj VARCHAR(14) NOT NULL DEFAULT '12345678901234';

ALTER TABLE client
    ADD cpf VARCHAR(11) NOT NULL DEFAULT '12345678901';