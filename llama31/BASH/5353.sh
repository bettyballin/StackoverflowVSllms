impdp user/password@database directory=DPUMP_DIR dumpfile=EXPORT.DMP nologfile=y sqlfile=ddl.sql\ngrep "CREATE USER" ddl.sql | cut -d' ' -f3