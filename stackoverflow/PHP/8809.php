<?php\n$params = array('level' => 6, 'window' => 15, 'memory' => 9);\n\n$original_text = "You SQL queries here...";\n\n$fp = fopen('yourfile.sql.gz', 'w');\nstream_filter_append($fp, 'zlib.deflate', STREAM_FILTER_WRITE, $params);\nfwrite($fp, $original_text);\nfclose($fp);\n?>