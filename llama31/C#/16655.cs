using Oracle.ManagedDataAccess.Client;\n\n// Create a connection pool with a specific size\nvar pool = new OracleConnectionPool(5);\n\n// Create a connection from the pool\nvar conn = pool.GetConnection();