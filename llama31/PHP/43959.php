// Assuming your document root is /var/www/html\n// Store sensitive configuration data in /var/www/config.xml\n\n$configFile = '../config.xml'; // above the document root\n$xml = simplexml_load_file($configFile);\n$dbCredentials = (array)$xml->db;\n\n// Use the $dbCredentials array to connect to your database