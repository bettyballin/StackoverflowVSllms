define('SITEPATH', (dirname($_SERVER['SCRIPT_NAME']) == '/') ? '/' : dirname($_SERVER['SCRIPT_NAME']) . '/');\n$load_path = $_SERVER['DOCUMENT_ROOT'] . SITEPATH . 'fpo_image.jpg';\n\n$file_time = filemtime($load_path);\n$last_modified = gmdate('D, d M Y H:i:s', $file_time) . ' GMT';\n\n// Send headers to the client\nheader('Cache-Control: must-revalidate');\nheader('Last-Modified: ' . $last_modified);\n\nif (isset($_SERVER['HTTP_IF_MODIFIED_SINCE'])) {\n    $if_modified_since = strtotime($_SERVER['HTTP_IF_MODIFIED_SINCE']);\n    if ($if_modified_since >= $file_time) {\n        header('HTTP/1.1 304 Not Modified');\n        exit;\n    }\n}\n\nheader('HTTP/1.1 200 OK');\nheader('Content-Length: ' . filesize($load_path));\nheader('Content-Type: image/jpeg');\n\nreadfile($load_path);