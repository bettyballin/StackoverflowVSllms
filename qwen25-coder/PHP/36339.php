<?php\nheader("content-type:text/plain");\n\n$servername = "localhost";\n$username = "root";\n$password = "xxxx";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password);\n\n// Check connection\nif ($conn->connect_error) {\n    wText("Server connection failed");\n} else {\n    wText("Server connection created");\n\n    // Create database\n    $sql = "CREATE DATABASE tf2faq";\n    if ($conn->query($sql) === TRUE) {\n        wText("Database tf2faq created");\n    } else {\n        wText("Database tf2faq create failed: " . $conn->error);\n    }\n\n    // Select the database\n    $conn->select_db("tf2faq");\n\n    // Create table\n    $sql = 'CREATE TABLE `loadoutitems` (`item` TEXT NULL, `class` TEXT NULL, `type` TEXT NULL, `replaces` TEXT NULL, `itempos` TEXT NULL, `modpos` TEXT NULL, `modneg` TEXT NULL, `imgurl` TEXT NULL, `notes` TEXT NULL) ENGINE = MyISAM';\n    if ($conn->query($sql) === TRUE) {\n        wText("Table loadoutitems created");\n    } else {\n        wText("Table loadoutitems create failed: " . $conn->error);\n    }\n\n    // Load data from file\n    $filePath = '/full/path/to/loadoutitmsfx.csv'; // Ensure this path is correct\n    $sql = "LOAD DATA INFILE '" . $filePath . "' INTO TABLE `loadoutitems` FIELDS TERMINATED BY ','";\n    if ($conn->query($sql) === TRUE) {\n        wText("Data Load Passed");\n    } else {\n        wText("Data Load Failed: " . $conn->error);\n    }\n\n    // Close connection\n    $conn->close();\n}\n\nfunction wText($txt){\n    echo $txt . "\n";\n}\n?>