class DB {\n    private $conn;\n\n    // Database data\n    private $dbhost;\n    private $dbname;\n    private $dbuser;\n    private $dbpass;\n\n    /**\n     * Constructor\n     * @param string $dbhost the database host\n     * @param string $dbname the database name\n     * @param string $dbuser the database username\n     * @param string $dbpass the database password\n     */\n    public function __construct($dbhost, $dbname, $dbuser, $dbpass) {\n        $this->dbhost = $dbhost;\n        $this->dbname = $dbname;\n        $this->dbuser = $dbuser;\n        $this->dbpass = $dbpass;\n\n        // Open a connection\n        try {\n            $this->conn = new PDO("mysql:host=$dbhost;dbname=$dbname", $dbuser, $dbpass);\n            $this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n        } catch (PDOException $e) {\n            throw new Exception("Error connecting to database: " . $e->getMessage());\n        }\n    }\n\n    /**\n     * Closes the connection to a database\n     */\n    public function close() {\n        $this->conn = null;\n    }\n\n    /**\n     * Executes a given query string with parameters\n     * @param string $query the SQL query to execute\n     * @param array $params array of parameters to bind\n     * @return mixed the result object on success, False otherwise\n     */\n    public function query($query, $params = []) {\n        try {\n            $stmt = $this->conn->prepare($query);\n            foreach ($params as $key => &$val) {\n                $stmt->bindParam(":".$key, $val);\n            }\n            $stmt->execute();\n            return $stmt;\n        } catch (PDOException $e) {\n            throw new Exception("Error executing query: " . $e->getMessage());\n        }\n    }\n\n    /**\n     * Closes the connection upon object destruction\n     */\n    public function __destruct() {\n        $this->close();\n    }\n}