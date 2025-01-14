class Site_Mapper {\n    // Assume dbConnection is your database connection object\n    private $dbConnection;\n\n    public function fetch($id) {\n        // Fetch site data from the database by ID and return a new Site object\n        $query = "SELECT * FROM sites WHERE id = ?";\n        $stmt = $this->dbConnection->prepare($query);\n        $stmt->execute([$id]);\n        $data = $stmt->fetch(\PDO::FETCH_ASSOC);\n\n        if ($data) {\n            $site = new Site();\n            $site->id = $data['id'];\n            $site->isPrimary = (bool)$data['is_primary'];\n            // Populate other properties as necessary\n            return $site;\n        }\n\n        throw new Exception("Site not found");\n    }\n\n    public function save(Site $site) {\n        // Save the site data back to the database\n        if ($site->isPrimary) {\n            // First, unset any existing primary sites\n            $this->unsetCurrentPrimary();\n        }\n\n        $query = "UPDATE sites SET is_primary = :is_primary WHERE id = :id";\n        $stmt = $this->dbConnection->prepare($query);\n        $success = $stmt->execute([\n            'id' => $site->id,\n            'is_primary' => (int)$site->isPrimary\n        ]);\n\n        if (!$success) {\n            throw new Exception("Failed to save site");\n        }\n    }\n\n    private function unsetCurrentPrimary() {\n        // Unset the current primary site before setting a new one\n        $query = "UPDATE sites SET is_primary = 0 WHERE is_primary = 1";\n        $this->dbConnection->exec($query);\n    }\n}\n\nclass Site {\n    public $id;\n    public $isPrimary;\n\n    // Other properties and methods...\n}