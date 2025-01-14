<?php\n// Generate a temporary file\n$temp_file = 'temp_' . uniqid() . '.txt';\nfile_put_contents($temp_file, 'This is a temporary file.');\n\n// Record the creation time\n$creation_time = time();\nfile_put_contents($temp_file . '.time', $creation_time);\n\n// Provide the download link to the user\necho "Download your file: <a href='$temp_file'>$temp_file</a>";\n?>