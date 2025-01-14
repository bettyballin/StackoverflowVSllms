public function login($username, $pass, $remember) {\n    // establish a connection to the db securely\n    $connect = new connect();\n    $conn = $connect->login_connect();\n\n    // prepare your statement to prevent SQL injection\n    $stmt = $conn->prepare("SELECT * FROM login WHERE username=? AND password=SHA1(?);");\n    $stmt->bind_param("ss", $username, $pass);\n    $stmt->execute();\n    $result = $stmt->get_result();\n\n    if ($result->num_rows > 0) {\n        $row = $result->fetch_assoc();\n        \n        // assign user_id and username to session\n        $_SESSION['user_id'] = $row['user_id'];\n        $_SESSION['username'] = $username;\n\n        // start rememberMe process\n        if ($remember) {\n            // generate a random token\n            $token = bin2hex(random_bytes(32));\n            \n            // store token in database, associated with user_id or username\n            $stmt = $conn->prepare("UPDATE login SET remember_token=? WHERE user_id=?");\n            $stmt->bind_param("si", $token, $row['user_id']);\n            $stmt->execute();\n            \n            // set a secure cookie\n            $cookie_time = (3600 * 24 * 30); // 30 days\n            setcookie('db_auth', $token, time() + $cookie_time, '/', '', true, true);\n        }\n        \n        // redirect user to homepage\n        header('Location: http://localhost/v6/home/index.php');\n        exit();\n    } else {\n        throw new depException('Incorrect username and password combination. Please try again.');\n    }\n}\n\n// On page load or login failure, check for the remember me cookie\nif (isset($_COOKIE['db_auth'])) {\n    $cookie = $_COOKIE['db_auth'];\n    \n    // check if cookie matches any stored token in db\n    $stmt = $conn->prepare("SELECT * FROM login WHERE remember_token=?");\n    $stmt->bind_param("s", $cookie);\n    $stmt->execute();\n    $result = $stmt->get_result();\n\n    if ($result->num_rows > 0) {\n        // set session variables and remove the token for security\n        $row = $result->fetch_assoc();\n\n        $_SESSION['user_id'] = $row['user_id'];\n        $_SESSION['username'] = $row['username'];\n        \n        // optionally regenerate session id to prevent fixation\n        session_regenerate_id(true);\n\n        // remove cookie from db or renew token securely\n        $stmt = $conn->prepare("UPDATE login SET remember_token=NULL WHERE user_id=?");\n        $stmt->bind_param("i", $row['user_id']);\n        $stmt->execute();\n\n        // redirect to homepage\n        header('Location: http://localhost/v6/home/index.php');\n        exit();\n    }\n}