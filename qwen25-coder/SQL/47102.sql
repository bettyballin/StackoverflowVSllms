CREATE OR REPLACE PACKAGE BODY remote_exec AS\n     PROCEDURE execute_dynamic_sql(p_sql VARCHAR2) IS\n     BEGIN\n       EXECUTE IMMEDIATE p_sql;\n     END;\n   END remote_exec;