-- Set the PLSQL_CODE_TYPE to NATIVE\nALTER SYSTEM SET PLSQL_CODE_TYPE = 'NATIVE' SCOPE=SPFILE;\n\n-- Restart the database\nSHUTDOWN IMMEDIATE;\nSTARTUP;\n\n-- Recompile a specific package\nALTER PACKAGE your_package_name COMPILE PLSQL_CODE_TYPE=NATIVE;