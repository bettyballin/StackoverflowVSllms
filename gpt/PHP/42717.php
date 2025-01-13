<?php\n   // Enable output buffering for header redirection\n   ob_start();\n\n   // Include database connection\n   require 'db_connection.php';\n   \n   // Use a caching mechanism (e.g., file-based caching, Memcached, etc.)\n   $cache_enabled = true;\n   $cache_time = 3600; // Cache time in seconds\n   $cache_path = 'cache/';\n   \n   $slug = $_GET['slug'];\n\n   // Check if caching is enabled and if the cache file exists\n   if ($cache_enabled) {\n       $cache_file = $cache_path . md5($slug) . '.cache';\n       if (file_exists($cache_file) && (time() - filemtime($cache_file) < $cache_time)) {\n           $data = file_get_contents($cache_file);\n           $data = unserialize($data);\n       } else {\n           // Fetch from database if cache is not valid\n           $data = get_permalink_data($slug);\n           // Save to cache\n           file_put_contents($cache_file, serialize($data));\n       }\n   } else {\n       // Fetch directly from the database\n       $data = get_permalink_data($slug);\n   }\n\n   if ($data) {\n       // Redirect to the appropriate URL using the id from the database\n       header("Location: /content.php?id=" . $data['id']);\n       exit();\n   } else {\n       // Handle permalink not found\n       header("HTTP/1.0 404 Not Found");\n       echo "Page not found.";\n       exit();\n   }\n\n   function get_permalink_data($slug) {\n       global $db_connection;\n       $stmt = $db_connection->prepare("SELECT id FROM permalinks WHERE slug = ?");\n       $stmt->bind_param("s", $slug);\n       $stmt->execute();\n       $result = $stmt->get_result();\n       return $result->fetch_assoc();\n   }\n   ?>