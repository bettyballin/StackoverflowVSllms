SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, CHARACTER_MAXIMUM_LENGTH\nFROM INFORMATION_SCHEMA.COLUMNS\nORDER BY TABLE_NAME, COLUMN_NAME;\n\nSELECT TABLE_NAME, INDEX_NAME, COLUMN_NAME\nFROM INFORMATION_SCHEMA.STATISTICS\nORDER BY TABLE_NAME, INDEX_NAME, COLUMN_NAME;