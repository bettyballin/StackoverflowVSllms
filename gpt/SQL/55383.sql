ALTER SESSION SET sql_trace = TRUE;\n  EXEC PKGTEST.DoSomething(:cur_OUT);\n  ALTER SESSION SET sql_trace = FALSE;