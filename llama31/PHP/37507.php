// Generate a token and store it in the session\n$token = uniqid();\n$_SESSION['token'] = $token;\n\n// Use the token in the link\n<a href="page.php?token=<?php echo $token; ?>">Click here</a>