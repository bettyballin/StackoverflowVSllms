<?php\n\ninclude('encrypt.php');\ninclude('invoice.class.php');\n\n// Define a secret key for encryption\ndefine('SECRET_KEY', 'your-secret-key-here');\n\nfunction encryptData($data) {\n    // Use a secure encryption method\n    return base64_encode(openssl_encrypt($data, 'aes-256-cbc', SECRET_KEY, 0, SECRET_KEY));\n}\n\nfunction decryptData($data) {\n    // Use a secure decryption method\n    return openssl_decrypt(base64_decode($data), 'aes-256-cbc', SECRET_KEY, 0, SECRET_KEY);\n}\n\nif (isset($_REQUEST['invoice'])) {\n    $invoiceData = decryptData($_REQUEST['invoice']);\n    $invoice = unserialize($invoiceData);\n    if (!($invoice instanceof invoice)) {\n        throw new exception('Something bad happened');\n    }\n} else {\n    // Some pages throw an exception if the $_REQUEST doesn't exist.\n    $invoice = new invoice();\n}\n\nif (isset($_REQUEST['action']) && $_REQUEST['action'] == 'addLine') {\n    // Validate input data\n    $description = filter_input(INPUT_POST, 'description', FILTER_SANITIZE_STRING);\n    $qty = filter_input(INPUT_POST, 'qty', FILTER_VALIDATE_INT);\n    $unitprice = filter_input(INPUT_POST, 'unitprice', FILTER_VALIDATE_FLOAT);\n\n    if ($description && $qty && $unitprice) {\n        $invoice->addLine(new invoiceLine($description, $qty, $unitprice));\n    } else {\n        throw new exception('Invalid input data');\n    }\n}\n?>\n<form action="index.php" method="post">\n    <input type="text" name="description" placeholder="Description" required />\n    <input type="number" name="qty" placeholder="Quantity" required />\n    <input type="number" step="0.01" name="unitprice" placeholder="Unit Price" required />\n    <input type="hidden" name="invoice" value="<?php echo encryptData(serialize($invoice)); ?>" />\n    <input type="submit" value="Add Line" />\n</form>