function arrayToCSV($vectorDados, $cabecalho)\n{\n    $arr = $vectorDados;\n\n    $csv = $cabecalho . "\n";\n    foreach ($arr as $row) {\n        // Use commas to separate CSV fields and trim spaces\n        $csv .= trim(implode(',', $row)) . "\n";\n    }\n    $filename = "emails_" . date("Y-m-d_H-i", time()) . ".csv";\n\n    // Make sure no output has been sent prior to sending the headers\n    ob_clean();\n    flush();\n\n    header("Content-Type: text/csv");\n    header("Content-Disposition: attachment; filename=" . $filename);\n    header("Content-Length: " . strlen($csv));\n    header("Connection: close");\n\n    echo $csv;\n    exit(); // Ensure no other code executes after output\n}