CONNECT TO your_database_name;\nEXPORT TO /path/to/result.csv OF DEL MODIFIED BY COLDEL, "CHARSET=UTF-8"\nSELECT col1, col2, coln FROM testtable t;