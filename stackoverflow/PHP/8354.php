<?php \nfunction array_keep($array, $keys) {\n    return array_intersect_key($array, array_fill_keys($keys, null));\n}\n\n$array = array(\n    'key1' => 'value1',\n    'key2' => 'value2',\n    'key57' => 'value57'\n);\n\n$newArray = array_keep($array, array('key2', 'key57'));\n\nprint_r($newArray);