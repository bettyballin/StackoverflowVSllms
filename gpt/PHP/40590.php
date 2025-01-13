<?php\n$servername = "your_server";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\n$conn = new mysqli($servername, $username, $password, $dbname);\n\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\ntry {\n    // Start transaction\n    $conn->begin_transaction();\n\n    // Insert into profiles table\n    $sqlProfile = "INSERT INTO profiles (profile_data) VALUES ('your_profile_data')";\n    if ($conn->query($sqlProfile) === TRUE) {\n        $profileId = $conn->insert_id;\n\n        // Insert into users table\n        $sqlUser = "INSERT INTO users (username, password, profile_id) VALUES ('your_username', 'your_password', $profileId)";\n        if ($conn->query($sqlUser) === TRUE) {\n            // Commit transaction\n            $conn->commit();\n            echo "New records created successfully";\n        } else {\n            // Rollback transaction\n            $conn->rollback();\n            echo "Error: " . $sqlUser . "<br>" . $conn->error;\n        }\n    } else {\n        // Rollback transaction\n        $conn->rollback();\n        echo "Error: " . $sqlProfile . "<br>" . $conn->error;\n    }\n\n} catch (Exception $e) {\n    // Rollback transaction in case of error\n    $conn->rollback();\n    echo "Transaction failed: " . $e->getMessage();\n}\n\n$conn->close();\n?>