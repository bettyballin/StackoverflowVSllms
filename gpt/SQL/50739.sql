LOAD DATA\nINFILE 'data.txt'\nINTO TABLE your_table\nFIELDS TERMINATED BY '|'\nOPTIONALLY ENCLOSED BY '"'\nTRAILING NULLCOLS\n(\n    id                  INTEGER EXTERNAL,\n    description         CHAR(4000) "REPLACE(:description, '<BR>', CHR(10))",\n    more_data           CHAR(255),\n    sentinel            FILLER CHAR(6)\n)\nCONTINUEIF LAST != '|ENDREC'