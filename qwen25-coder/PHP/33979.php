<?php\nheader('Content-Type: application/javascript');\n$callback = isset($_GET['callback']) ? $_GET['callback'] : 'callback';\n$data = array('key' => 'value');\necho $callback . '(' . json_encode($data) . ');';\n?>