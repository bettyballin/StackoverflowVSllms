<?php\n$servername = "localhost";\n$username = "your_username"; // replace with your MySQL username\n$password = "your_password"; // replace with your MySQL password\n$dbname = "your_database"; // replace with your database name\n\n$conn = mysqli_connect($servername, $username, $password, $dbname);\n\nif (!$conn) {\n    die("Connection failed: " . mysqli_connect_error());\n}\n\n$query = "SELECT * FROM story";\n$result = mysqli_query($conn, $query) or die(mysqli_error($conn));\n\necho "<h1>Delete Story</h1>";\n\nif (mysqli_num_rows($result) > 0) {\n    while($row = mysqli_fetch_row($result)){\n        echo '<b>'.$row[1].'</b><span align="right"><a href="../process/delete_story.php?id='.$row[0].'">Delete</a></span>';\n        echo '<br /><i>'.$row[2].'</i><br/>';\n    }\n} else {\n   echo "No stories available.";\n}\n\nmysqli_close($conn);\n?>