<?php\n$db_name = "coolmates";\n$db_server = "localhost";\n$db_user = "justron";\n$db_pass = "Justron9004";\n\n$mysqli = new MySQLi($db_server, $db_user, $db_pass, $db_name) or die(mysqli_error($mysqli));\n\n?>