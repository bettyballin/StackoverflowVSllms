$asd['a'] = 10;\n$asd['b'] = 1;\n$asd['c'] = 6;\n$asd['d'] = 3;\n\n$keys = array_keys($asd);\n$values = array_values($asd);\n\narsort($values);\n$sortedKeys = array_slice($keys, 0, 4);\n\nprint_r($sortedKeys);