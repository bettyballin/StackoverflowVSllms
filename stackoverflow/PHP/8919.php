<?php\n\n// Locate.\n$file_name = 'file.avi';\n$file_url = 'http://www.myremoteserver.com/' . $file_name;\n\n// Configure.\nheader('Content-Type: application/octet-stream');\nheader("Content-Transfer-Encoding: Binary"); \nheader("Content-disposition: attachment; filename=\"".$file_name."\"");\n\n// Actual download.\nreadfile($file_url);\n\n// Finally, just to be sure that remaining script does not output anything.\nexit;