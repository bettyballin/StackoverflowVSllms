-- Example: Exporting schema from Oracle 9i\nexpdp username/password@oracle9i schemas=your_schema directory=exp_dir dumpfile=your_schema.dmp logfile=expdp_your_schema.log\n\n-- Example: Importing schema to Oracle 11g\nimpdp username/password@oracle11g schemas=your_schema directory=imp_dir dumpfile=your_schema.dmp logfile=impdp_your_schema.log