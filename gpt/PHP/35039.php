<?php\nsession_start();\n\nif (!isset($_SESSION['counter'])) {\n    $_SESSION['counter'] = 0;\n}\n\n$_SESSION['counter']++;\n\necho "You have visited this page " . $_SESSION['counter'] . " times.";\n?>