if ($_POST) {\n    $content = $_POST['content'];\n    $by = $_SESSION['exp_user']['username'];\n    $dt = date("F j, Y, g:i a");\n\n    // Assuming $mysqli is your database connection object\n    $stmt = $mysqli->prepare("UPDATE tbl_intmsg SET time=?, by=?, content=? WHERE some_id_field=?");\n    \n    // Replace 'i' with the actual type of your ID field (e.g., i for integer)\n    $stmt->bind_param('sssi', $dt, $by, $content, $your_id_value);\n    \n    // Execute the statement\n    if (!$stmt->execute()) {\n        die($mysqli->error);\n    }\n    \n    $stmt->close();\n}