$string = "var1=val1 var2=val2 var3='this is a test'";\n\n$vars = array();\n$i = 0;\nwhile ($i < strlen($string)) {\n\n    $eqIndex = strpos($string, "=", $i);\n    $varName = substr($string, $i, $eqIndex - $i);\n\n    $i = $eqIndex + 1;\n\n    if ($string[$i] == "'") \n    {\n        $varEndIndex = strpos($string, "'", ++$i);\n    }\n    else\n    {\n        $varEndIndex = strpos($string, " ", $i);\n        if ($varEndIndex === FALSE) $varEndIndex = strlen($string);\n    }\n\n    $varValue = substr($string, $i, $varEndIndex - $i);\n\n    $vars[$varName] = $varValue;\n\n    $i = $varEndIndex + 1;\n}\n\nprint_r($vars);