if (isset($_GET['token']) && $_GET['token'] === $_SESSION['token']) {\n    // Token is valid, user is authenticated\n    // ...\n} else {\n    // Token is invalid, redirect to login page or error page\n    // ...\n}