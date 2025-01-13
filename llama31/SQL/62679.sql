CREATE DATABASE snapshot_test_db_ss ON (\n    NAME = 'test_db',\n    FILENAME = 'C:\temp\snapshot_test_db.ss'\n) AS SNAPSHOT OF test_db;\n\n-- Perform database operations here\n-- ...\n\nRESTORE DATABASE test_db FROM DATABASE_SNAPSHOT = 'snapshot_test_db_ss';