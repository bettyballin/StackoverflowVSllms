$file = fopen('output.txt', 'w');\nfwrite($file, "Hello,\nWorld!\n");\nfclose($file);