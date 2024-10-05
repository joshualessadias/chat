ALTER TABLE client
    ADD CONSTRAINT uc_client_phone_number UNIQUE (phone_number);