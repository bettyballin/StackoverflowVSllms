$input_date = '03-JUL-09 14';\n$dt = DateTime::createFromFormat('d-M-y H', $input_date);\nif ($dt !== false) {\n    $formatted_date = $dt->format('Y-m-d H:i:s');\n    echo $formatted_date;\n} else {\n    echo 'Invalid date format';\n}