LOAD DATA\nINFILE 'yourfile.txt'\nINTO TABLE your_table_name\nFIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'\nTRAILING NULLCOLS (\n    column1,\n    column2,\n    description ":RTRIM(:column3, '\\n')"\n)\nCONTINUEIF NEXT 3:4 != '"END"'\n\n-- In data file, after escaping line breaks and marking the end of record\nfield1,field2,"This is a\ndescription\nwith line\nbreaks","END"