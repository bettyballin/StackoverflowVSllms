<?php\nclass DatabaseSessionHandler implements SessionHandlerInterface {\n    private $pdo;\n\n    public function __construct($dsn, $user = '', $password = '') {\n        try {\n            $this->pdo = new PDO($dsn, $user, $password);\n            $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n        } catch (PDOException $e) {\n            die("Could not connect to the database: " . $e->getMessage());\n        }\n    }\n\n    public function open($savePath, $sessionName) {\n        return true;\n    }\n\n    public function close() {\n        // Normally you don't need to do anything here\n        return true;\n    }\n\n    public function read($id) {\n        $stmt = $this->pdo->prepare("SELECT session_data FROM sessions WHERE session_id = :id");\n        $stmt->execute([':id' => $id]);\n        $row = $stmt->fetch(PDO::FETCH_ASSOC);\n\n        if ($row !== false) {\n            return $row['session_data'];\n        }\n        return '';\n    }\n\n    public function write($id, $data) {\n        $modified = time();\n        $stmt = $this->pdo->prepare("INSERT INTO sessions (session_id, session_data, last_modified) VALUES (:id, :data, :time)\n                                    ON DUPLICATE KEY UPDATE session_data = :data, last_modified = :time");\n        return $stmt->execute([\n            ':id' => $id,\n            ':data' => $data,\n            ':time' => $modified\n        ]);\n    }\n\n    public function destroy($id) {\n        $stmt = $this->pdo->prepare("DELETE FROM sessions WHERE session_id = :id");\n        return $stmt->execute([':id' => $id]);\n    }\n\n    public function gc($maxlifetime) {\n        $threshold = time() - $maxlifetime;\n        $stmt = $this->pdo->prepare("DELETE FROM sessions WHERE last_modified < :time");\n        return $stmt->execute([':time' => $threshold]);\n    }\n}\n\n$dsn = 'mysql:host=your_host;dbname=your_db';\n$user = 'your_user';\n$password = 'your_password';\n\n$sessionHandler = new DatabaseSessionHandler($dsn, $user, $password);\nsession_set_save_handler($sessionHandler, true);\n\nsession_start();\n?>