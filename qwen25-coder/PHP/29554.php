// Example usage\n$ftpGetter = new FTPDataGetter();\n$csvHandler = new CSVDataHandler();\n$mysqlWriter = new MySQLDataWriter();\n\n$importExecutor = new DataImportExecutor($ftpGetter, $csvHandler, $mysqlWriter);\n$importExecutor->execute();