<?php\ninclude_once('./json.php'); \n$output = array('var1' => array('value1a', 'value1b', 'value1c'), \n                'var2' => array('value2a', 'value2b', 'value2c')); \n\nheader("Content-Type: application/json");\necho json_encode($output);\n?>