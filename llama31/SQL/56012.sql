-- Comments\n/* Multi-line comment */\n-- Single-line comment\n\n-- SELECT\nSELECT * FROM table_name;\nSELECT column1, column2 FROM table_name;\n\n-- FROM\nFROM table_name AS alias;\n\n-- WHERE\nWHERE condition;\nWHERE column_name = 'value';\n\n-- AND, OR, NOT\nWHERE condition1 AND condition2;\nWHERE condition1 OR condition2;\nWHERE NOT condition;\n\n-- IN, BETWEEN\nWHERE column_name IN ('value1', 'value2');\nWHERE column_name BETWEEN 'value1' AND 'value2';\n\n-- LIKE\nWHERE column_name LIKE '%pattern%';\n\n-- ORDER BY\nORDER BY column_name ASC/DESC;\n\n-- LIMIT\nLIMIT offset, row_count;\n\n-- JOIN\nINNER JOIN table2 ON table1.column_name = table2.column_name;\nLEFT JOIN table2 ON table1.column_name = table2.column_name;\n\n-- GROUP BY\nGROUP BY column_name;\n\n-- HAVING\nHAVING condition;\n\n-- INSERT\nINSERT INTO table_name (column1, column2) VALUES ('value1', 'value2');\n\n-- UPDATE\nUPDATE table_name SET column1 = 'value1' WHERE condition;\n\n-- DELETE\nDELETE FROM table_name WHERE condition;