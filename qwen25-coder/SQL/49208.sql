-- Four-part naming\n   SELECT * FROM [OracleServer]..[SCHEMA].[TABLE];\n\n   -- Using OPENQUERY for complex queries\n   SELECT * FROM OPENQUERY(OracleServer, 'SELECT * FROM SCHEMA.TABLE');