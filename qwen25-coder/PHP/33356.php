<?php\n$user = isset($_GET['u']) ? $_GET['u'] : false;\n$id = isset($_GET['i']) ? $_GET['i'] : false;\n$s = isset($_GET['s']) ? $_GET['s'] : 0;\n\nif (!$user && !$id) {\n    // display a lock!\n    exit(0);\n}\n\nrequire_once("bootstrap_minimal.php"); // setup db connection, etc\n\n$stmt = $db->query('SELECT image_id, user_id, file_name, private FROM images WHERE image_id = ?', [$id]);\n$obj = $stmt->fetchObject();\n\nif (!$obj) {\n    // display a lock or error if needed\n    exit(0);\n}\n\nif ($obj->user_id != $_SESSION['user_id'] && $obj->private == 1) {\n    // check permissions and display a lock if needed\n    exit(0);\n}\n\n$picture = ($s === '0') ? $common->getImagePathThumb($obj->file_name) : $common->getImagePath($obj->file_name);\n\nif (!file_exists($picture)) {\n    exit(0); // or handle error appropriately\n}\n\n$file_size = filesize($picture);\n$file_mtime = filemtime($picture);\n\n// Set headers for caching\nheader("Cache-Control: public, max-age=86400"); // Cache for 1 day\nheader("Expires: " . gmdate('D, d M Y H:i:s \G\M\T', time() + 86400)); // Expire in 1 day\nheader("Last-Modified: " . gmdate('D, d M Y H:i:s \G\M\T', $file_mtime));\n\n// Content headers\nheader("Content-Type: image/png");\nheader("Content-Length: $file_size");\n\n$fp = fopen($picture, 'rb');\nfpassthru($fp);\nexit;\n?>