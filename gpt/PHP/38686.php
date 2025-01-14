<?php\n// get_cookie.php\n\nif (isset($_GET['cookieName'])) {\n    $cookieName = $_GET['cookieName'];\n    if (isset($_COOKIE[$cookieName])) {\n        echo json_encode(["status" => "success", "cookieValue" => $_COOKIE[$cookieName]]);\n    } else {\n        echo json_encode(["status" => "error", "message" => "Cookie not found"]);\n    }\n} else {\n    echo json_encode(["status" => "error", "message" => "Invalid input"]);\n}\n?>