$videoFile = 'path/to/video.mp4';\n$chunkSize = 1024 * 1024; // 1MB\n\nheader('Content-Type: video/mp4');\nheader('Content-Disposition: inline; filename="video.mp4"');\n\n$fp = fopen($videoFile, 'rb');\nwhile (!feof($fp)) {\n    $chunk = fread($fp, $chunkSize);\n    echo $chunk;\n    flush();\n}\nfclose($fp);