$pgConnection = pg_connect('host=127.0.0.1 dbname=test user=myuser password=xxxxx')\n    or die('cant connect');\n\npg_query("BEGIN");\n\n$insert = pg_query("INSERT INTO customer (name) VALUES ('blabla') RETURNING id");\n\n$last_id_results = pg_fetch_assoc($insert);\n\nprint_r($last_id_results);\n\n//do somethings with the new customer id\n\npg_query("COMMIT");\n\npg_close($pgConnection);