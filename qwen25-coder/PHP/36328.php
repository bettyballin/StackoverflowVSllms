$Date = date("Y-m-d"); // Format date in Y-m-d which is SQL friendly\n$result = mysql_query("SELECT * FROM service WHERE SType = 'Retreat' AND STR_TO_DATE(Start_date, '%m/%d/%Y') > '$Date'");\n\n// Assuming you want to fetch and display the results:\nwhile ($row = mysql_fetch_assoc($result)) {\n    echo "ID: " . $row['id'] . ", Start Date: " . $row['Start_date'] . "\n";\n}