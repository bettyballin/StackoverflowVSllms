<?php\n// Assuming $quantity is the value from the form input\n$quantity = $_POST['quantity']; \n\nif (!is_numeric($quantity)) {\n    // Redirect to another page if the input is not numeric\n    header("Location: /badinput");\n    exit();\n} else {\n    // Process the numeric input\n    echo "The quantity is numeric.";\n}\n?>