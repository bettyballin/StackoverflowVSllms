$database = new PDO("mysql:host=host;dbname=mysql_db","username","password");\n\n// Set the PDO error mode to exception\n$database->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\ntry {\n    // Begin the transaction\n    $database->beginTransaction();\n\n    while (notDone()) {\n        $add_row = $database->prepare("INSERT INTO table (columns) VALUES (?)");\n        $add_row->execute(array('values'));\n\n        // PROCESSING STUFF THAT TAKES A LONG TIME GOES HERE\n    }\n\n    // Commit the transaction if everything went well\n    $database->commit();\n} catch (Exception $e) {\n    // Rollback the transaction if something went wrong\n    $database->rollBack();\n    throw $e; // Re-throw the exception\n}\n\n$database = null;