class Site_Mapper {\n    protected $db;\n\n    public function __construct($db) {\n        $this->db = $db;\n    }\n\n    public function fetch($id) {\n        // Your logic to fetch a Site object based on the ID\n    }\n\n    public function save($site) {\n        $this->db->beginTransaction();\n        try {\n            if ($site->isPrimary) {\n                $this->unsetCurrentPrimary();\n            }\n            // Your logic to save the Site object\n            $this->db->commit();\n        } catch (Exception $e) {\n            $this->db->rollBack();\n            throw $e;\n        }\n    }\n\n    protected function unsetCurrentPrimary() {\n        // Your logic to find and unset the current primary site\n        $sql = "UPDATE sites SET isPrimary = false WHERE isPrimary = true";\n        $stmt = $this->db->prepare($sql);\n        $stmt->execute();\n    }\n}