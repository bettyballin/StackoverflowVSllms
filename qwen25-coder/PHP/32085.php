<?php\n$directory = '/path/to/directory/';\n$filename = 'image.jpg';\n$file = $directory . $filename;\n\nif (file_exists($file)) {\n    echo "The file exists.";\n} else {\n    echo "The file does not exist.";\n}\n?>