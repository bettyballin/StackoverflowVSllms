<?php\nif ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_FILES['userfile'])) {\n    if (move_uploaded_file($_FILES['userfile']['tmp_name'], "/path/to/temp/" . $_FILES['userfile']['name'])) {\n        // Redirect to process.php with the file name as a parameter or use session\n        $_SESSION['uploaded_file'] = "/path/to/temp/" . $_FILES['userfile']['name'];\n        header("Location: process.php");\n        exit();\n    } else {\n        echo "Error uploading file.";\n    }\n}\n?>\n<form action="registration.php" method="post" enctype="multipart/form-data">\n    Send this file: <input name="userfile" type="file">\n    <input type="submit" value="Send File">\n</form>