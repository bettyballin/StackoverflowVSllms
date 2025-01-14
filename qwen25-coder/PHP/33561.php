<?php\ninclude 'databaseConnection.php'; // Include your database connection file\n\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $id = $_POST['id'];\n\n    // Sanitize and validate the input\n    if(is_numeric($id)) { // Simple check, consider using prepared statements for better security\n        $query = "DELETE FROM tbl_payments WHERE id = ?";\n        \n        // Using prepared statement to prevent SQL injection\n        if ($stmt = mysqli_prepare($conn, $query)) {\n            mysqli_stmt_bind_param($stmt, "i", $id);\n            \n            if (mysqli_stmt_execute($stmt)) {\n                echo "success";\n                exit;\n            } else {\n                echo "error executing query: " . mysqli_error($conn);\n            }\n        } else {\n            echo "Error preparing statement";\n        }\n\n        mysqli_stmt_close($stmt);\n    } else {\n        echo "Invalid ID";\n    }\n}\n\nmysqli_close($conn);\n?>