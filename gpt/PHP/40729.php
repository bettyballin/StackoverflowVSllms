<?php\nsession_start();\n\nif (isset($_POST['login'])) {\n    $username = mysql_real_escape_string($_POST['username']);\n    $password = mysql_real_escape_string($_POST['password']);\n\n    $query = mysql_query("SELECT id FROM users WHERE username = '$username' AND password = '$password'");\n\n    if (!mysql_num_rows($query)) {\n        header("Location: error.php");\n        exit();\n    }\n\n    $_SESSION['id'] = mysql_result($query, 0, 'id');\n    mysql_query("UPDATE users SET last_login = NOW(), last_ip = '{$_SERVER['REMOTE_ADDR']}' WHERE id = '{$_SESSION['id']}'");\n\n    header("Location: success.php");\n    exit();\n}\n\nif (isset($_GET['logout'])) {\n    mysql_query("UPDATE users SET online = '0' WHERE id = '{$_SESSION['id']}'");\n    session_unset();\n    session_destroy();\n    header("Location: index.php");\n    exit();\n}\n?>\n\n<!DOCTYPE html>\n<html>\n<head>\n    <title>Login</title>\n</head>\n<body>\n<?php if (!isset($_SESSION['id'])): ?>\n    <form method="post" action="./">\n        <p>\n            Username: <br />\n            <input type="text" name="username" size="22" maxlength="30" />\n            <br />\n            Password: <br />\n            <input type="password" name="password" size="22" maxlength="20" />\n            <br />\n            <input class="button" type="submit" name="login" value="Login" />\n        </p>\n    </form>\n<?php else: ?>\n    <p>Logged in</p>\n<?php endif; ?>\n</body>\n</html>