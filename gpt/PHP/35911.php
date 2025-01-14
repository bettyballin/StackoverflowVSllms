<?php\n// Connection to MySQL\n$con = mysqli_connect("your_host", "your_username", "your_password", "your_database");\n\n// Check connection\nif (mysqli_connect_errno()) {\n    echo "Failed to connect to MySQL: " . mysqli_connect_error();\n    exit();\n}\n\n// SQL query to create the table\n$sql = "CREATE TABLE qotwQuestion1111 (\n    QuestionId INT PRIMARY KEY AUTO_INCREMENT,\n    Question VARCHAR(5000),\n    MemberId VARCHAR(255),\n    PostDate DATE,\n    Vote INT,\n    FOREIGN KEY (MemberId) REFERENCES qotwMember(MemberId)\n)";\n\n// Execute query\nif (mysqli_query($con, $sql)) {\n    echo "Table qotwQuestion1111 created successfully";\n} else {\n    echo "Error creating table: " . mysqli_error($con);\n}\n\n// Close connection\nmysqli_close($con);\n?>