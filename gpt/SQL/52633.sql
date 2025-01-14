BEGIN TRANSACTION;\n\n-- Set the isolation level to ensure data consistency\nSET TRANSACTION ISOLATION LEVEL SERIALIZABLE;\n\n-- Perform your update operations\nUPDATE my_table\nSET column_name = new_value\nWHERE condition;\n\n-- Commit the transaction\nCOMMIT;