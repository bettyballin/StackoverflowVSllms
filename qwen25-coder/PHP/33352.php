$result = exec('/usr/python/bin/python3 ../cgi-bin/tabular.py 1 2>&1', $output, $return_var);\n   echo "<pre>" . htmlspecialchars(implode("\n", $output)) . "</pre>";