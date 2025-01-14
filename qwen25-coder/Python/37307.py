#!/usr/bin/python\nimport os\nimport cx_Oracle\nimport defs as df\n\n# Use environ to set environment variables\nos.environ['ORACLE_HOME'] = '/oracledb/10.2.0/'\nos.environ['LD_LIBRARY_PATH'] = '/oracledb/10.2.0/lib'\n\ntry:\n    con = cx_Oracle.Connection(df.DB_USER, df.DB_PASS, df.DB_SID)\n    print("Connection established:", con)\nexcept cx_Oracle.InterfaceError as e:\n    print("Failed to connect:", str(e))