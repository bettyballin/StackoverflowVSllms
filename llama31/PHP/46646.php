<?php\n$email_id = $_GET['email_id'];\n$url = $_GET['url'];\n// Log the request and update the email status\n// ...\nheader('Location: ' . $url);\nexit;\n?>