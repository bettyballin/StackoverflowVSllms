$fp = fsockopen("your_server_ip", 3333, $errno, $errstr, 10);\nif (!$fp) {\n    echo "$errstr ($errno)";\n} else {\n    fwrite($fp, "your_secret_knock_sequence");\n    fclose($fp);\n}