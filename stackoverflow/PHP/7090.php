<?php\n  $string = ">Data 1-23</a>";\n  $pattern = '/>([^<]*)</a>/';\n  preg_match($pattern, $subject, $matches);\n  print_r($matches);\n?>