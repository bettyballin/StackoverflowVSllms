require 'some_path/db-com.php';\n\n$dbCom = new DBCom("SELECT * FROM your_table");\n$resultArray = $dbCom->get_query_array();\nprint_r($resultArray);