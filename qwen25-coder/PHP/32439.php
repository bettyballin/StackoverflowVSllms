usort($myArray, function($a, $b){\n  if ($a == $b) return 0;\n  return ($a < $b) ? -1 : 1;\n});