<?php\nsession_start();\n\n// Assuming you have checked the credentials and they are valid\n$_SESSION['email'] = $_POST['email'];\n$_SESSION['passhash_md5'] = md5($_POST['password']);\n\nheader("Location: /codes/index.php?ask_question");\nexit();\n?>