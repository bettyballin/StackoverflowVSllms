EXEC sp_configure 'show advanced options', 1;\n   RECONFIGURE;\n   EXEC sp_configure 'Ad Hoc Distributed Queries', 1;\n   RECONFIGURE;