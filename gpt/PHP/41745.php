function variable_load($arg1, $arg2) {\n  // Your logic to determine if the page should be not found\n  $condition = check_some_condition($arg1, $arg2);\n\n  if ($condition) {\n    // Return page not found\n    drupal_not_found();\n    drupal_exit();\n  }\n\n  // Continue with normal page rendering process\n  // ...\n}\n\nfunction check_some_condition($arg1, $arg2) {\n  // Implement your condition check logic here\n  // Return TRUE if the condition to show 404 is met, otherwise FALSE\n  return ($arg1 == 'some_value' && $arg2 == 'another_value');\n}