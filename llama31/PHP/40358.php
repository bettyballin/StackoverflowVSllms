// append.php\n<?php\n// log response\n$log = 'responses.log';\nfile_put_contents($log, date('Y-m-d H:i:s') . ' ' . http_response_code() . PHP_EOL, FILE_APPEND);\n?>