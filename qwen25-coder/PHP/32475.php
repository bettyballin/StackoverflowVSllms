<?php\n$basePrice = 10;\n$totalPrice = $basePrice;\n\nif (isset($_POST['colorValue']) && is_numeric($_POST['colorValue'])) {\n    $totalPrice += (int)$_POST['colorValue'];\n}\n\nif (isset($_POST['sizeValue']) && is_numeric($_POST['sizeValue'])) {\n    $totalPrice += (int)$_POST['sizeValue'];\n}\n\necho $totalPrice;\n?>