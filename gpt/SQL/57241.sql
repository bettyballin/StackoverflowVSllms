-- Prepare a statement\nPREPARE my_statement (int, text) AS\nINSERT INTO my_table (id, name) VALUES ($1, $2);\n\n-- Execute the prepared statement\nEXECUTE my_statement(1, 'example');\n\n-- Deallocate the prepared statement\nDEALLOCATE my_statement;