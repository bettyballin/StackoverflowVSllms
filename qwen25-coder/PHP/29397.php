function isNotEmpty($input) \n{\n    $strTemp = trim($input);\n\n    if (strlen($strTemp) > 0)\n    {\n         return true;\n    }\n\n    return false;\n}