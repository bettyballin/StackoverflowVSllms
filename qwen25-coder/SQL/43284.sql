SET STATISTICS TIME ON;\n\n-- Your query here\nSELECT * FROM @search_temp_table;\n\nSET STATISTICS TIME OFF;