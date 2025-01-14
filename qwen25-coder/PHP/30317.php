<?php\n\ninclude('encrypt.php');\ninclude('invoice.class.php');\n\n// Function to generate a CSRF token\nfunction get_csrf_token() {\n    if (session_status() == PHP_SESSION_NONE) {\n        session_start();\n    }\n    if (!isset($_SESSION['csrf_token'])) {\n        $_SESSION['csrf_token'] = bin2hex(random_bytes(32));\n    }\n    return $_SESSION['csrf_token'];\n}\n\n// Function to validate CSRF token\nfunction validate_csrf_token($input_token) {\n    if (session_status() == PHP_SESSION_NONE) {\n        session_start();\n    }\n    return hash_equals($_SESSION['csrf_token'], $input_token);\n}\n\n$csrf_token = get_csrf_token();\n\nif(isset($_POST['invoice']) && isset($_POST['csrf'])) {\n    if (!validate_csrf_token($_POST['csrf'])) {\n        throw new Exception('CSRF validation failed');\n    }\n\n    $decrypted_invoice = decrypt(base64_decode($_POST['invoice']));\n    try {\n        $invoice = unserialize($decrypted_invoice);\n    } catch (Exception $e) {\n        throw new Exception('Something bad happened during unserialization', 0, $e);\n    }\n    \n    if(!($invoice instanceof invoice)) {\n        throw new Exception('Invalid serialized object type');\n    }\n\n    // Validate and sanitize inputs\n    if(isset($_POST['action']) && $_POST['action'] == 'addLine' &&\n       isset($_POST['description']) && isset($_POST['qty']) && isset($_POST['unitprice'])) {\n\n        $description = filter_var($_POST['description'], FILTER_SANITIZE_STRING);\n        $qty = filter_var($_POST['qty'], FILTER_VALIDATE_INT, ['options' => ['min_range' => 1]]);\n        $unit_price = filter_var($_POST['unitprice'], FILTER_VALIDATE_FLOAT);\n\n        if ($description !== false && $qty !== false && $unit_price !== false) {\n            $invoice->addLine(new invoiceLine($description, $qty, $unit_price));\n        }\n    }\n} else {\n    // No existing object - start new\n    $invoice = new invoice();\n}\n\n?>\n\n<form action="index.php" method="post">\n    <input type="hidden" name="csrf" value="<?php echo htmlspecialchars($csrf_token); ?>" />\n    <input type="text" name="qty" required/>\n    <input type="number" name="unitprice" step="0.01" required/>\n    <textarea name="description" required></textarea>\n    <input type="submit" name="action" value="addLine"/>\n    <input type="hidden" name="invoice" value="<?php echo htmlspecialchars(base64_encode(encrypt(serialize($invoice)))); ?>" />\n</form>