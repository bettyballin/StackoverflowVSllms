<?php\n   $email = 'user@example.com';\n\n// Bind the parameter\n   $statement->bindParam(':email', $email, PDO::PARAM_STR);\n\n// Execute the statement\n   $statement->execute();\n   ?>