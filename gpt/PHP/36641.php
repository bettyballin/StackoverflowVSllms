<?php\n$handle = fsockopen("tcp://xxx.xxx.xxx.xxx", 12345);\nfwrite($handle, "ls");\n\nstream_set_timeout($handle, 2); // Set a timeout for the stream\n\n$response = '';\nwhile (!feof($handle)) {\n    $buffer = fgets($handle, 4096);\n    if ($buffer === false) {\n        break;\n    }\n    $response .= $buffer;\n}\n\necho $response;\nfclose($handle);\n?>