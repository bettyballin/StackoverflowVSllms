java -jar liquibase.jar --driver=com.microsoft.sqlserver.jdbc.SQLServerDriver \\n  --classpath=sqljdbc.jar --url=jdbc:sqlserver://localhost:1433;databaseName=yourdb \\n  --username=youruser --password=yourpassword \\n  --changeLogFile=path/to/changelog.xml update