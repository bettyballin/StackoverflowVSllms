$dateTime = '2008-09-01 12:35:45';\nif (preg_match('/^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}$/', $dateTime)) {\n    echo "Valid datetime format.";\n} else {\n    echo "Invalid datetime format.";\n}