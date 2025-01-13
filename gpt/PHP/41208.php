// Set custom session handler\nclass MySQLSessionHandler implements SessionHandlerInterface {\n    private $pdo;\n\n    public function __construct($pdo) {\n        $this->pdo = $pdo;\n    }\n\n    public function open($savePath, $sessionName) {\n        // No action necessary because connection is injected\n        return true;\n    }\n\n    public function close() {\n        // No action necessary because connection is managed externally\n        return true;\n    }\n\n    public function read($id) {\n        $stmt = $this->pdo->prepare("SELECT data FROM sessions WHERE id = :id");\n        $stmt->execute(['id' => $id]);\n        return (string) $stmt->fetchColumn();\n    }\n\n    public function write($id, $data) {\n        $stmt = $this->pdo->prepare("REPLACE INTO sessions (id, data, last_access) VALUES (:id, :data, NOW())");\n        return $stmt->execute(['id' => $id, 'data' => $data]);\n    }\n\n    public function destroy($id) {\n        $stmt = $this->pdo->prepare("DELETE FROM sessions WHERE id = :id");\n        return $stmt->execute(['id' => $id]);\n    }\n\n    public function gc($maxlifetime) {\n        $stmt = $this->pdo->prepare("DELETE FROM sessions WHERE last_access < NOW() - INTERVAL :maxlifetime SECOND");\n        return $stmt->execute(['maxlifetime' => $maxlifetime]);\n    }\n}\n\n// Set up the PDO connection\n$pdo = new PDO('mysql:host=localhost;dbname=test', 'username', 'password');\n\n// Set the custom session handler\n$handler = new MySQLSessionHandler($pdo);\nsession_set_save_handler($handler, true);\n\n// Start the session\nsession_start();\n\n// Example of session usage\n$_SESSION['key'] = 'value';\n\n// Close the session write to release the lock\nsession_write_close();