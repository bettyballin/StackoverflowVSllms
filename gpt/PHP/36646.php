class Db\n{\n    private static $_instance = NULL;\n\n    private function __construct() {\n        // cannot call me\n    }\n\n    private function __clone() {\n        // no cloning\n    }\n\n    public static function getInstance() {\n        if (!self::$_instance) {\n            try {\n                self::$_instance = new PDO('mysql:host=' . CONFIG_MYSQL_SERVER . ';dbname=' . CONFIG_MYSQL_DATABASE, CONFIG_MYSQL_USERNAME, CONFIG_MYSQL_PASSWORD);\n                self::$_instance->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n            } catch (PDOException $e) {\n                error_log($e->getMessage());\n                throw new Exception("Database connection error");\n            }\n        }\n        return self::$_instance;\n    }\n\n    public static function query($query, $bindings = NULL) {\n        try {\n            $isSelect = stripos(trim($query), 'SELECT') === 0;\n            $prepared = self::getInstance()->prepare($query);\n\n            if ($bindings) {\n                foreach ($bindings as $binding => $data) {\n                    if (!is_array($data)) {\n                        $prepared->bindParam($binding, $data);\n                    } else {\n                        $prepared->bindParam($binding, $data['value'], $data['dataType'] ?? PDO::PARAM_STR, $data['length'] ?? null);\n                    }\n                }\n            }\n\n            $prepared->execute();\n\n            if ($isSelect) {\n                return $prepared->fetchAll(PDO::FETCH_ASSOC);\n            } else {\n                return $prepared->rowCount();\n            }\n        } catch (PDOException $e) {\n            error_log($e->getMessage());\n            throw new Exception("Database query error");\n        }\n    }\n\n    public static function getLastInsertId() {\n        try {\n            return self::getInstance()->lastInsertId();\n        } catch (PDOException $e) {\n            error_log($e->getMessage());\n            throw new Exception("Failed to get last insert ID");\n        }\n    }\n\n    public static function disconnect() {\n        self::$_instance = NULL;\n    }\n}