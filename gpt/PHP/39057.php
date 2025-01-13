<?php\n$mysqli = new mysqli("localhost", "user", "password", "database");\n\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\nif (($handle = fopen("products.csv", "r")) !== FALSE) {\n    while (($data = fgetcsv($handle, 1000, ",")) !== FALSE) {\n        $sku = $mysqli->real_escape_string($data[0]);\n        $name = $mysqli->real_escape_string($data[1]);\n        $description = $mysqli->real_escape_string($data[2]);\n        $price = $mysqli->real_escape_string($data[3]);\n\n        $sql = "INSERT INTO products (sku, name, description, price) VALUES ('$sku', '$name', '$description', '$price')\n                ON DUPLICATE KEY UPDATE name='$name', description='$description', price='$price'";\n\n        if (!$mysqli->query($sql)) {\n            echo "Error: " . $sql . "<br>" . $mysqli->error;\n        }\n    }\n    fclose($handle);\n}\n\n$mysqli->close();\n?>