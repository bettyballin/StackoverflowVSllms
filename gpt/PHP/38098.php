<?php\nsession_start();\nif (isset($_SESSION['token'])) {\n    $token = $_SESSION['token'];\n    echo '<a href="stream.php?token=' . $token . '">View Stream</a>';\n}\n?>