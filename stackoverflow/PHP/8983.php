<?php\n\n$jsonurl = "http://search.twitter.com/trends.json";\n$json = file_get_contents($jsonurl,0,null,null);\n$json_output = json_decode($json);\n\nforeach ( $json_output->trends as $trend )\n{\n    echo "{$trend->name}\n";\n}