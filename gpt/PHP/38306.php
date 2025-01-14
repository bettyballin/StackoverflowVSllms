function IsPrime($num) {\n    global $primesto, $primes, $lastprime;\n\n    // Save current array pointer position\n    $current_key = key($primes);\n    $current_value = current($primes);\n\n    if ($primesto >= $num)\n        return isset($primes[$num]);\n\n    $root = (int) sqrt($num);\n    if ($primesto < $root)\n        CalcPrimesTo($root);\n\n    foreach($primes as $p) {\n        if ($num % $p == 0)\n            return false;\n\n        if ($p >= $root)\n            break;\n    }\n\n    // Restore array pointer position\n    reset($primes);\n    while (key($primes) !== $current_key && next($primes) !== false);\n\n    return true;\n}\n\n// Your main code\n$primes = array(\n    2 => 2,\n    3 => 3,\n    5 => 5,\n    7 => 7,\n    11 => 11,\n    13 => 13,\n    17 => 17,\n    // ...etc\n);\n\n// Seek to first prime greater than 10000\nreset($primes);\nwhile(next($primes) < 10000) {}\nprev($primes);\n\n// Iterate until target found\nwhile($p = next($primes)) {\n    $res = doSomeCalculationsOn($p);\n\n    if (IsPrime($res))\n        return $p;\n}