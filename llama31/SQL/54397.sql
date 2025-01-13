CREATE FULLTEXT INDEX ON your_table (primary_key) \nWITH (FORMAT='CUSTOM', DATA_COMPRESSION='NONE');\n\nALTER FULLTEXT CATALOG [your_catalog_name] \nADD WORD BREAKER LANGUAGE ' Neutral' \nFROM 'path\to\custom\word\breaker.dll';\n\nSELECT * \nFROM FREETEXTTABLE(your_table, primary_key, 'abcd') AS ft \nINNER JOIN your_table ON ft.[KEY] = your_table.primary_key;