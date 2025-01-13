<?php\n$order_fields = array('starts', 'ends', 'cltt', 'binding state', 'next binding state', 'hardware ethernet', 'uid', 'client-hostname');\n$fields_regexp = '';\nforeach ($order_fields as $field)\n{\n    $fields_regexp .= "\s*".$field." (.*)";\n}\n$regexp = '/lease (\b(?:[0-9]{1,3}\.){3}[0-9]{1,3}\b) \{'.$fields_regexp.'\s*\}/m';\npreg_match_all($regexp, $string, $result, PREG_PATTERN_ORDER);\n\n$arr = array();\nforeach ($result[1] as $i => $match) {\n    $cont = count($arr[$match]);\n    $arr[$match][$cont]['raw'] = $result[0][$i];\n    $arr[$match][$cont]['ip'] = $match;\n    foreach ($order_fields as $pos => $field)\n    {\n        $arr[$match][$cont][$field] = $result[$pos + 2][$i];\n    }\n}\nprint_r($arr);\n?>