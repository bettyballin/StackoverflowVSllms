<?php\nheader('Content-Type: application/javascript');\necho $_GET['callback'] . '({"message":"Hello World","version":"1.0"});';\n?>