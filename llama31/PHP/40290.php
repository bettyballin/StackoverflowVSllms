$src = "/var/videos/video1.wmv";\n$command = "/usr/bin/ffmpeg -i " . $src;\n$output = array();\nexec($command, $output, $status);\nforeach ($output as $line) {\n    echo $line . "\n";\n}