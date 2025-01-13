<?php\n// Set up your database connection\ntry {\n    $dbh = new PDO('mysql:host=your_host;dbname=your_db', 'your_user', 'your_password');\n    $dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n} catch (PDOException $e) {\n    echo "Connection failed: " . $e->getMessage();\n    exit();\n}\n\n$sql = 'INSERT INTO somedatetable (something) \n        VALUES (:something) \n        ON DUPLICATE KEY UPDATE something=:something';\n\n$values = array(":something" => $something);\n\ntry {\n    $stmt = $dbh->prepare($sql);    \n    $stmt->execute($values);    \n} catch (PDOException $e) {\n    echo "Error: " . $e->getMessage() . "<br />";\n}\n?>