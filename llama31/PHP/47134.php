$fp = gzopen('example.gz', 'r');\nwhile (!gzeof($fp)) {\n    echo gzgets($fp);\n}\ngzclose($fp);