function escapeCSV(&$string) {\n    $string = str_replace('"', '""', $string);\n    if (strpos($string, ',') !== false) {\n        $string = '"' . $string . '"';\n    }\n    return $string;\n}