CREATE TABLE mytable (\n    table_identifier_a   INTEGER    NULL,\n    table_identifier_b   INTEGER    NOT NULL,\n    table_value1         INTEGER    NOT NULL,\n\n    UNIQUE(table_identifier_a, table_identifier_b)\n);