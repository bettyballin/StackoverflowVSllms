function fixCase($str)\n{\n  if ( \n       (strcmp($str, strtolower($str)) === 0) || \n       (strcmp($str, strtoupper($str)) === 0) ) \n  {\n    $str = ucwords(strtolower($str));\n  }\n\n  return $str;\n}