CREATE TABLE #MyTestTable\n(TABLE_QUALIFIER sysname, \nTABLE_OWNER sysname, \nTABLE_NAME sysname, \nCOLUMN_NAME sysname, \nDATA_TYPE smallint, \nTYPE_NAME sysname, \nPRECISION int, \nLENGTH int, \nSCALE smallint, \nRADIX smallint, \nNULLABLE smallint, \nREMARKS varchar(254), \nCOLUMN_DEF nvarchar(4000), \nSQL_DATA_TYPE smallint, \nSQL_DATETIME_SUB smallint, \nCHAR_OCTET_LENGTH int, \nORDINAL_POSITION int, \nIS_NULLABLE varchar(254), \nSS_DATA_TYPE tinyint)\n\nINSERT  #MyTempTable\nEXEC    sp_columns 'tblSomeTableName'\n\nSELECT  COLUMN_NAME\nFROM    #MyTempTable\nWHERE   ...