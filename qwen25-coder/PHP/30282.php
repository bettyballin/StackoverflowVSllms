<?php\nerror_reporting(E_ALL);\nini_set('display_errors', 1);\n\n$uploadDir = '/absolute/path/to/uploads/';\n$target = $uploadDir . basename($_FILES['uploaded']['name']);\n\nif (file_exists($target)) {\n    echo "<br />Sorry, there is already a file with that name on the server.<br />Please press back on your browser and save the file under a different name.";\n} else {\n    if (move_uploaded_file($_FILES['uploaded']['tmp_name'], $target)) {\n        echo "The file ". basename( $_FILES['uploaded']['name']). " has been uploaded";\n        // Insert into database\n        mysql_query("INSERT INTO media (id, related_page_id, type, title, copy, path, position, assets, time) VALUES ('', '$cat','$type','$name','','$target','$position','$id','$today')");\n        header("Location: edit.php?category=$cat");\n        exit();\n    } else {\n        echo "Sorry, there was a problem uploading your file. Please press back on your browser and try again.";\n    }\n}\n?>