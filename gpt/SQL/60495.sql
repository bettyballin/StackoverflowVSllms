SELECT * FROM dblink('dbname=databaseB user=your_username password=your_password', 'SELECT * FROM public.someTableName')\n   AS t(column1 datatype, column2 datatype, ...);