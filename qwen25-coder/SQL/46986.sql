LOAD DATA\nINFILE 'data.csv'\nINTO TABLE your_table_name\nFIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'\nTRAILING NULLCOLS\n(\n    column1,\n    column2 DATE "MM/DD/YYYY",\n    column3 NUMBER\n)