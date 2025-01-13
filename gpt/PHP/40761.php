class Database {\n       private $host = 'localhost';\n       private $db = 'mydatabase';\n       private $user = 'username';\n       private $pass = 'password';\n       private $conn;\n\n       public function __construct() {\n           $this->conn = new PDO("mysql:host=$this->host;dbname=$this->db", $this->user, $this->pass);\n       }\n\n       public function query($sql, $params = []) {\n           $stmt = $this->conn->prepare($sql);\n           $stmt->execute($params);\n           return $stmt->fetchAll(PDO::FETCH_ASSOC);\n       }\n   }