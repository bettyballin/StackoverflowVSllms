$dateString = '02/15/2023'; // Your date in MM/DD/YYYY format\n$dateObject = DateTime::createFromFormat('m/d/Y', $dateString);\n$mysqlFormatDate = $dateObject->format('Y-m-d');\n\n// Now you can use $mysqlFormatDate in your MySQL query\n$sql = "INSERT INTO your_table (date_column) VALUES ('$mysqlFormatDate')";