$sqliteConnection = new SQLiteDatabase('path/to/db');\n$queryString = "DELETE FROM myTable WHERE status='not good'";\n$result = $sqliteConnection->query($queryString);\n$affectedRows = $sqliteConnection->changes();\n\necho "Affected rows: $affectedRows";