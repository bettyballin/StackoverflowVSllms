$dh = opendir($dir);\nif ($dh === false) die("opendir returned failure");\nwhile (($item = readdir($dh)) !== false) {\n    print $item . "\n";\n}\nclosedir($dh);