CREATE TABLE wicket (\n    id BIGINT AUTO_INCREMENT PRIMARY KEY\n    -- other columns\n);\n\nCREATE TABLE wicket_type_mapping (\n    wicket_id BIGINT NOT NULL,\n    wicket_type VARCHAR(255) NOT NULL,\n    FOREIGN KEY (wicket_id) REFERENCES wicket(id)\n);