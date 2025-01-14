class MySessionHandler {\n       private $pdo;\n\n       public function __construct(PDO $pdo) {\n           $this->pdo = $pdo;\n       }\n\n       public function open($savePath, $sessionName) {\n           return true;\n       }\n\n       public function close() {\n           return true;\n       }\n\n       public function read($id) {\n           $stmt = $this->pdo->prepare("SELECT data FROM php_sessions WHERE id = :id");\n           $stmt->execute([':id' => $id]);\n           $result = $stmt->fetch(PDO::FETCH_ASSOC);\n           if ($result) {\n               return $result['data'];\n           }\n           return '';\n       }\n\n       public function write($id, $data) {\n           $time = time();\n           $stmt = $this->pdo->prepare("REPLACE INTO php_sessions (id, access, data) VALUES (:id, :access, :data)");\n           return $stmt->execute([':id' => $id, ':access' => $time, ':data' => $data]);\n       }\n\n       public function destroy($id) {\n           $stmt = $this->pdo->prepare("DELETE FROM php_sessions WHERE id = :id");\n           return $stmt->execute([':id' => $id]);\n       }\n\n       public function gc($maxlifetime) {\n           $deadline = time() - $maxlifetime;\n           $stmt = $this->pdo->prepare("DELETE FROM php_sessions WHERE access < :deadline");\n           return $stmt->execute([':deadline' => $deadline]);\n       }\n   }\n\n   // Configure PDO connection\n   $dsn = 'mysql:host=localhost;dbname=testdb;charset=utf8mb4';\n   $username = 'root';\n   $password = '';\n\n   try {\n       $pdo = new PDO($dsn, $username, $password);\n       $sessionHandler = new MySessionHandler($pdo);\n       session_set_save_handler(\n           [$sessionHandler, 'open'],\n           [$sessionHandler, 'close'],\n           [$sessionHandler, 'read'],\n           [$sessionHandler, 'write'],\n           [$sessionHandler, 'destroy'],\n           [$sessionHandler, 'gc']\n       );\n       register_shutdown_function('session_write_close');\n       session_start();\n   } catch (PDOException $e) {\n       die("Error : " . $e->getMessage());\n   }