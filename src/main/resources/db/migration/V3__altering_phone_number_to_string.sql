ALTER TABLE client
    DROP COLUMN phone_number;

ALTER TABLE client
    ADD phone_number VARCHAR(11) NOT NULL DEFAULT '00000000000';

ALTER TABLE message
    DROP COLUMN receiver_phone_number;

ALTER TABLE message
    ADD receiver_phone_number VARCHAR(11) NOT NULL DEFAULT '00000000000';