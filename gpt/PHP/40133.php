// Storing data in Memcached\n   $memcache = new Memcached();\n   $memcache->addServer('localhost', 11211);\n   $memcache->set('key', 'value', 3600); // Cache for 1 hour\n\n   // Fetching data from Memcached\n   $value = $memcache->get('key');\n   if ($value) {\n       echo $value;\n   } else {\n       // Data not found in cache, fetch from the original source\n   }