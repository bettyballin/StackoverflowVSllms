<?php\n$array = [\n    'apple',\n    'orange',\n    'pear',\n    'banana',\n    'apple',\n    'pear',\n    'kiwi',\n    'kiwi',\n    'kiwi'\n];\n\n$valueCounts = array_count_values($array);\n\nforeach ($valueCounts as $value => $count) {\n    if ($count > 1) {\n        echo "$value ($count)\n";\n    } else {\n        echo "$value\n";\n    }\n}\n?>