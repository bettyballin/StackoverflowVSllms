EXEC sp_configure 'clr enabled', 1;\n     RECONFIGURE;\n     EXEC sp_configure 'max server memory (MB)', <SQL_MEMORY>;\n     RECONFIGURE;\n     EXEC sp_configure 'clr memory max mb', <CLR_MEMORY>;\n     RECONFIGURE;