$files = array('2819547919_db7466149b_o_d.jpg', 'GP1-green2.jpg', 'aegeri-lake-switzerland.JPG');\nforeach($files as $file){\n  $size2 = array();\n  $size3 = array();\n  $time1 = microtime();\n  $size = getimagesize($file);\n  $time1 = microtime() - $time1;\n  print "$time1 \n";\n  $time2 = microtime();\n  exec("identify -ping $file", $size2);\n  $time2 = microtime() - $time2;\n  print $time2/$time1 . "\n";\n  $time2 = microtime();\n  exec("identify $file", $size3);\n  $time2 = microtime() - $time2;\n  print $time2/$time1 . "\n";\n  print_r($size);\n  print_r($size2);\n  print_r($size3);\n}