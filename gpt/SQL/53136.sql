-- Connect to the S1 schema\nsqlplus S1_user/password@DB1\n\n-- Create a temporary table\nCREATE TABLE temp_table2 AS SELECT * FROM S2.Table2 WHERE 1=0;\n\n-- Load data from the file\nLOAD DATA \nINFILE 'table2_data.csv'\nINTO TABLE temp_table2\nFIELDS TERMINATED BY ',' \n(\n    column1,\n    column2,\n    ...\n    columnN\n);