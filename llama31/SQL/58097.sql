LOAD DATA\nINFILE SampleFile.dat\nREPLACE\nINTO TABLE contact\nFIELDS TERMINATED BY '|'\nOPTIONALLY ENCLOSED BY '"'\n(\nID, \nFIRST_NAME,\nLAST_NAME,\nEMAIL,\nDEPARTMENT_ID,\nLAST_UPDATED EXPR "SYSTIMESTAMP"\n)