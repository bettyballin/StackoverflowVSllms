<?php\nsession_start();\n\n// Simple function to hash passwords\nfunction hashPassword($password) {\n    return password_hash($password, PASSWORD_BCRYPT);\n}\n\n// Function to verify password\nfunction verifyPassword($plainPassword, $hashedPassword) {\n    return password_verify($plainPassword, $hashedPassword);\n}\n\n// User data storage - in a real application this would be a database\n$users = [\n    'exampleuser' => hashPassword('securepassword123'), // Replace with your own hashed passwords\n];\n\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    if (isset($_POST['action']) && $_POST['action'] === 'login') {\n        $username = $_POST['username'];\n        $password = $_POST['password'];\n\n        if (isset($users[$username]) && verifyPassword($password, $users[$username])) {\n            $_SESSION['user'] = $username;\n            echo "Login successful!";\n        } else {\n            echo "Invalid username or password.";\n        }\n    }\n}\n\nif (isset($_SESSION['user'])) {\n    echo "Welcome, " . htmlspecialchars($_SESSION['user']) . "! <a href='?logout=1'>Logout</a>";\n} else {\n?>\n<form method="post" action="">\n    Username: <input type="text" name="username"><br>\n    Password: <input type="password" name="password"><br>\n    <input type="hidden" name="action" value="login">\n    <button type="submit">Login</button>\n</form>\n<?php\n}\n\nif (isset($_GET['logout'])) {\n    session_unset();\n    session_destroy();\n    header('Location: ' . $_SERVER['PHP_SELF']);\n    exit;\n}\n?>