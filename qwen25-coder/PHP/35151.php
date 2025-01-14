header('Content-Type: text/html; charset=utf-8');\n   \n   // Set MySQLi connection options\n   $mysqli = new mysqli($host, $user, $password, $db);\n   if ($mysqli->connect_error) {\n       die("Connection failed: " . $mysqli->connect_error);\n   }\n   $mysqli->set_charset('utf8mb4');\n\n   // Or for PDO:\n   try {\n       $pdo = new PDO("mysql:host=$host;dbname=$db;charset=utf8mb4", $user, $password, [\n           PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,\n           PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8mb4',\n       ]);\n   } catch (PDOException $e) {\n       die($e->getMessage());\n   }