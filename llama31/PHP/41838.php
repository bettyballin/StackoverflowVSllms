$cacheDir = '../cache/';\n$levels = 3; // adjust to your needs\n$file = $cacheDir;\nfor ($i = 0; $i < $levels; $i++) {\n    $file .= substr($id, $i * 2, 2) . '/';\n}\n$file .= $id . '.htm';\n\n// create directories if they don't exist\nmkdir($file, 0777, true);\n\n$handle = fopen($file, 'w');\nfwrite($handle, $temp);\nfclose($handle);