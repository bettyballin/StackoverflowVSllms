$output = [];\n   system('/usr/python/bin/python3 ../cgi-bin/tabular.py 1 2>&1', $return_var);\n   echo "<pre>" . htmlspecialchars($output) . "</pre>";