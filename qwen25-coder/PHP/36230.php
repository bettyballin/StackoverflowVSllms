putenv('PATH=/opt/local/bin:' . getenv('PATH'));\nputenv('DYLD_LIBRARY_PATH=/opt/local/lib:' . getenv('DYLD_LIBRARY_PATH'));\n\n$cmd = "/opt/local/bin/convert '/WEBSERVER/images/img_0003-192-10.png' -thumbnail x320 -resize '320x<' -resize 50% -gravity center -crop 160x120+0+0 +repage -quality 91 '/WEBSERVER/thumbs/small_img_0003-192-10.png'";\nexec($cmd, $output, $retval);\n$errors += $retval;\nif ($errors > 0) {\n    die(print_r($output));\n}