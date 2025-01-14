<?php\n// Sanitize and validate input data\n$name = filter_input(INPUT_POST, 'orderName', FILTER_SANITIZE_STRING);\n$company = filter_input(INPUT_POST, 'orderCompany', FILTER_SANITIZE_STRING);\n$email = filter_input(INPUT_POST, 'orderEmail', FILTER_VALIDATE_EMAIL);\n$phone = filter_input(INPUT_POST, 'orderPhone', FILTER_SANITIZE_STRING);\n\n$item1 = filter_input(INPUT_POST, 'orderItem1', FILTER_SANITIZE_STRING);\n$qty1 = filter_input(INPUT_POST, 'orderQty1', FILTER_VALIDATE_INT);\n\n$item2 = filter_input(INPUT_POST, 'orderItem2', FILTER_SANITIZE_STRING);\n$qty2 = filter_input(INPUT_POST, 'orderQty2', FILTER_VALIDATE_INT);\n\n$item3 = filter_input(INPUT_POST, 'orderItem3', FILTER_SANITIZE_STRING);\n$qty3 = filter_input(INPUT_POST, 'orderQty3', FILTER_VALIDATE_INT);\n\n$date = date("l, F j Y, G:i");\n$headers = "From: $email\r\n";\n$message = "Message sent: $date\n\n"\n         . "Name: $name\n"\n         . "Company: $company\n"\n         . "Email: $email\n"\n         . "Phone: $phone\n\n"\n         . "Order:\n"\n         . "$item1 \tx$qty1\n"\n         . "$item2 \tx$qty2\n"\n         . "$item3 \tx$qty3\n";\n\n// Send the email\nif ($email) {\n    mail("sales@company.com", "Order", $message, $headers);\n} else {\n    echo "Invalid email address.";\n}\n?>