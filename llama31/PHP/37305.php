$file_path = 'global.css';\n$file_mtime = filemtime($file_path);\n$if_modified_since = isset($_SERVER['HTTP_IF_MODIFIED_SINCE']) ? $_SERVER['HTTP_IF_MODIFIED_SINCE'] : null;\n\nif(extension_loaded('zlib')){\n    ob_start('ob_gzhandler');\n}\n\n$offset = 60 * 60 * 24 * 31;\nheader('Content-type: text/css');\nheader('Cache-Control: public, max-age=' . $offset);\nheader('Expires: ' . gmdate ("D, d M Y H:i:s", time() + $offset) . ' GMT');\nheader('Last-Modified: ' . gmdate ("D, d M Y H:i:s", $file_mtime) . ' GMT');\nheader('ETag: ' . md5($file_mtime));\n\nif ($if_modified_since && strtotime($if_modified_since) >= $file_mtime) {\n    header('HTTP/1.1 304 Not Modified');\n    exit;\n}\n\nob_start("compress");\n\nfunction compress($buffer) {\n    // Remove Comments, White Space, End ;'s\n    $buffer = preg_replace('#/\*.*?\*/#s', '', $buffer);\n    $buffer = preg_replace('/\s*([{}|:;,])\s+/', '$1', $buffer);\n    $buffer = preg_replace('/\s\s+(.*)/', '$1', $buffer);\n    $buffer = str_replace(';}', '}', $buffer);\n    $buffer = str_replace(' {', '{', $buffer);\n    return $buffer;\n}\n\ninclude($file_path);\n\nif(extension_loaded('zlib')){\n    ob_end_flush();\n}