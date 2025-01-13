$new = array_reduce(array_keys($old), function($carry, $key) use ($old) {\n    $lowerKey = strtolower($key);\n    if (array_key_exists($lowerKey, $carry)) {\n        throw new Exception('Duplicate Key Encountered');\n    }\n    $carry[$lowerKey] = $old[$key];\n    return $carry;\n}, []);