<?php\nsession_start();\n\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $username = $_POST['username'];\n    $password = $_POST['password'];\n\n    // Check username and password (this should be hashed and stored securely)\n    if ($username === 'your_username' && $password === 'your_password') {\n        $_SESSION['user'] = $username;\n        header("Location: /home");\n        exit();\n    } else {\n        echo "Invalid credentials.";\n    }\n}\n?>\n\n<form method="post" action="">\n Username: <input type="text" name="username"><br>\n Password: <input type="password" name="password"><br>\n <input type="submit" value="Login">\n</form>