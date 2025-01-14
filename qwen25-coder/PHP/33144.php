<?php\nsession_start();\ninclude 'config.php'; // Database configuration details\n\n// Login process\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    $email = mysqli_real_escape_string($conn, $_POST['email']);\n    $password = mysqli_real_escape_string($conn, $_POST['password']);\n\n    $query = "SELECT * FROM users WHERE email='$email'";\n    $result = mysqli_query($conn, $query);\n\n    if (mysqli_num_rows($result) == 1) {\n        $user = mysqli_fetch_assoc($result);\n        if (password_verify($password, $user['password'])) { // Assuming password is hashed\n            $_SESSION['user_id'] = $user['id'];\n            header("Location: dashboard.php");\n            exit();\n        } else {\n            echo "Invalid credentials.";\n        }\n    } else {\n        echo "No user found with that email address.";\n    }\n}\n?>