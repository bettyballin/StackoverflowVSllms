class TreeGenerator {\n    private $pdo;\n    private $parent_id_field = 'parent_id';\n    private $name_field = 'name';\n    private $nodes = [];\n    private $select = [];\n\n    public function __construct($dsn, $user, $password) {\n        try {\n            $this->pdo = new PDO($dsn, $user, $password);\n            $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n        } catch (PDOException $e) {\n            throw new Exception("Could not connect to the database");\n        }\n    }\n\n    public function init($table, $parent_id = 0) {\n        $sql = "SELECT id, {$this->parent_id_field}, {$this->name_field} FROM $table WHERE {$this->parent_id_field}= :parent_id ORDER BY display_order";\n        $stmt = $this->pdo->prepare($sql);\n        $stmt->execute([':parent_id' => $parent_id]);\n        $result = $stmt->fetchAll(PDO::FETCH_OBJ);\n\n        $this->getTree($table, $result, 0);\n\n        // Output for debugging\n        print_r($this->nodes);\n        print_r($this->select);\n    }\n\n    private function getTree($table, $rows, $depth) {\n        foreach ($rows as $row) {\n            // Add node to nodes array\n            $this->nodes[$row->{$this->parent_id_field}][$row->id] = $row;\n\n            // Prepare text for select option with indentation based on depth\n            $text = str_repeat("    ", $depth) . $row->name;\n            $this->select[$row->id] = $text;\n\n            echo str_repeat("    ", $depth) . "$row->name\n";\n\n            // Fetch children of the current node\n            $sql = "SELECT id, {$this->parent_id_field}, {$this->name_field} FROM $table WHERE {$this->parent_id_field}= :parent_id ORDER BY display_order";\n            $stmt = $this->pdo->prepare($sql);\n            $stmt->execute([':parent_id' => $row->id]);\n            $childrenRows = $stmt->fetchAll(PDO::FETCH_OBJ);\n\n            if (!empty($childrenRows)) {\n                $this->getTree($table, $childrenRows, $depth + 1); // Increment depth for child nodes\n            }\n        }\n    }\n}\n\n// Usage example:\ntry {\n    $treeGenerator = new TreeGenerator("mysql:host=your_host;dbname=your_db", "your_user", "your_password");\n    $treeGenerator->init('your_table');\n} catch (Exception $e) {\n    echo 'Caught exception: ',  $e->getMessage(), "\n";\n}