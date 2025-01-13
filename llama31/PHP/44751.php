function getConnection() {\n    try {\n        $cn = new PDO("mysql:host=$host;dbname=$bd", $usuario, $clave, array(\n            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,\n            PDO::MYSQL_ATTR_USE_BUFFERED_QUERY => true\n        ));\n        return $cn;\n    } catch (PDOException $e) {\n        print "Error!: " . $e->getMessage() . "<br/>";\n        die();\n    }\n}