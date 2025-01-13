bool exists;\n\ntry\n{\n    // ANSI SQL way.  Works in PostgreSQL, MSSQL, MySQL.  \n    var cmd = new OdbcCommand(\n      "select case when exists((select * from information_schema.tables where table_name = '" + tableName + "')) then 1 else 0 end");\n\n    exists = (int)cmd.ExecuteScalar() == 1;\n}\ncatch\n{\n    try\n    {\n        // Other RDBMS.  Graceful degradation\n        exists = true;\n        var cmdOthers = new OdbcCommand("select 1 from " + tableName + " where 1 = 0");\n        cmdOthers.ExecuteNonQuery();\n    }\n    catch\n    {\n        exists = false;\n    }\n}