<?php\nheader('Content-Type: text/csv; charset=utf-8');\nheader('Content-Disposition: attachment; filename="data.csv"');\n\n$output = fopen('php://output', 'w');\n\n// Add BOM to UTF-8 encode the file\nfprintf($output, chr(0xEF).chr(0xBB).chr(0xBF));\n\n$data = array("Numéro 1");\nfputcsv($output, $data);\n\nfclose($output);\n?>