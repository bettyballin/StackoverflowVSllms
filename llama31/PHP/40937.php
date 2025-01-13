function get_mysqlDate($date) {\n    if (empty($date)) {\n        return 'NULL';\n    }\n    $datetime = DateTime::createFromFormat('d/m/Y', $date);\n    return $datetime->format('Y-m-d');\n}