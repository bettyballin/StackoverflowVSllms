function findAnchors($html) {\n    $names = array();\n    $p = '%<a.*\s+name=[\'"](.*)[\'"]\s*>(?:.*)</a>%im';\n    $t = preg_match_all($p, $html, $matches, PREG_SET_ORDER);\n    if ($matches) {\n        foreach ($matches as $m) {\n            $names[] = $m[1];\n        }\n        return $names;\n    }\n}