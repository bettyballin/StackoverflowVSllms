proc sql;\n    connect to sqlservr as DataSrc (server=my-db-srvr database=SasProcSqlTest);\n    \n    /* Insert records from SAS dataset into SQL Server table */\n    insert into DataSrc..tblItem (Name, Value)\n    select Name, Value\n    from Items;\n    \n    disconnect from DataSrc;\nquit;