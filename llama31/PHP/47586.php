<?php\n// everything is in a single file, no separation of concerns\n$foo = 'bar';\nif (isset($_GET['baz'])) {\n    $foo = $_GET['baz'];\n} elseif (isset($_POST['qux'])) {\n    $foo = $_POST['qux'];\n} else {\n    $foo = 'default';\n}\n\n// database query mixed with business logic and presentation\n$result = mysql_query("SELECT * FROM users WHERE name = '$foo'");\nwhile ($row = mysql_fetch_assoc($result)) {\n    echo "<p>Hello, " . $row['name'] . "!</p>";\n}\n\n// random functions and variables scattered throughout the code\nfunction add_two($x) {\n    return $x + 2;\n}\n$random_var = 42;\n?>