$username = htmlspecialchars($_POST['username'], ENT_QUOTES, 'UTF-8');\necho "<p>Hello, $username!</p>";