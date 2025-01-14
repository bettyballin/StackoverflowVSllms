if ($_GET['cmd'] === 'deleterec') {\n    $pk = $_GET['pk'];\n    // Assuming you have a connection in $conn, use prepared statements to prevent SQL injection\n    $stmt = $conn->prepare("DELETE FROM your_table WHERE article_no = ?");\n    $stmt->bind_param("i", $pk);\n    $stmt->execute();\n    \n    // After deleting, fetch the updated data and return it as HTML\n    $updatedContent = getUpdatedContent(); // Implement this function to construct HTML for table rows based on current data.\n    echo $updatedContent;\n}