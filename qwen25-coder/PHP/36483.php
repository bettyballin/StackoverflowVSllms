$fp = fopen($_SESSION['filename'], "r");\n\n// Read the first line to skip it but do not process it\nfgetcsv($fp, 1000, ",");\n\nwhile (($data = fgetcsv($fp, 1000, ",")) !== FALSE) {\n    // Your existing code for inserting data into the table\n    $import = "INSERT INTO csv_table(name,address,age) VALUES('" . mysqli_real_escape_string($connection, $data[0]) . "', '" . mysqli_real_escape_string($connection, $data[1]) . "', '" . mysqli_real_escape_string($connection, $data[2]) . "')";\n    mysqli_query($connection, $import) or die(mysqli_error($connection));\n}\n\nfclose($fp);