function foo($param_1) {\n  static $initialized = false;\n  if (!$initialized) {\n    doExpensiveStuff($param_1);\n    $initialized = true;\n  }\n  echo '<b>'.$param_1.'</b>';\n}