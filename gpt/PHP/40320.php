<?php\n$file = 'output.txt';\n$data = "Hello, World!\nThis is a new line.\n";\nfile_put_contents($file, $data);\n\n// Alternatively, using fopen() and fwrite()\n$handle = fopen($file, 'w');\nfwrite($handle, $data);\nfclose($handle);\n?>