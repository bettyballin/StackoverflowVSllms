<?php\n$file = fopen('output.txt', 'w');\nfwrite($file, "Hello, World!\n");\nfwrite($file, "This is on a new line.\n");\nfclose($file);