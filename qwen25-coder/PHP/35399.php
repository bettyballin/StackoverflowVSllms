<?php\n// Sample timestamp array\n$timestamps = [1245925436, 1256335200, 1245925436];\n\n// Convert the array to JSON format and output it\nheader('Content-Type: application/json');\necho json_encode($timestamps);\n?>