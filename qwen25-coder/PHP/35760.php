<?php\n$host = 'your_host';\n$dbname = 'your_db_name';\n$username = 'your_username';\n$password = 'your_password';\n\n// Create connection\n$conn = mysqli_connect($host, $username, $password, $dbname);\n\n// Check connection\nif (!$conn) {\n    die("Connection failed: " . mysqli_connect_error());\n}\n\n$post_id_to_delete = 1; // Replace with the actual post ID to be deleted\n\n// Start a transaction\nmysqli_begin_transaction($conn);\n\ntry {\n    // Delete comments for the specified post\n    $delete_comments_sql = "DELETE FROM Comments WHERE PostID = ?";\n    $comments_stmt = mysqli_prepare($conn, $delete_comments_sql);\n    mysqli_stmt_bind_param($comments_stmt, "i", $post_id_to_delete);\n    mysqli_stmt_execute($comments_stmt);\n\n    // Delete the post itself\n    $delete_post_sql = "DELETE FROM Posts WHERE PostID = ?";\n    $post_stmt = mysqli_prepare($conn, $delete_post_sql);\n    mysqli_stmt_bind_param($post_stmt, "i", $post_id_to_delete);\n    mysqli_stmt_execute($post_stmt);\n\n    // Commit the transaction\n    mysqli_commit($conn);\n    echo "Post and its comments have been deleted successfully.";\n    \n} catch (Exception $e) {\n    // Rollback in case of error\n    mysqli_rollback($conn);\n    echo "Error deleting post or comments: " . $e->getMessage();\n}\n\n// Close connections\nmysqli_stmt_close($comments_stmt);\nmysqli_stmt_close($post_stmt);\nmysqli_close($conn);\n?>