class Model_Artifact extends LP_Model_Factory_Abstract\n{\n    protected static $_artifactGateway = 'Model_Table_Artifact';\n\n    public function __construct($row = null)\n    {\n        parent::__construct($row);\n    }\n\n    // Any other non-static methods specific to Model_Artifact\n}\n\nclass Model_Artifact_Finder\n{\n    protected static $_artifactGateway = 'Model_Table_Artifact';\n    protected static $_collectionClass = 'LP_Model_Collection_Factory';\n\n    public static function create($params)\n    {\n        // Implement the create logic here\n    }\n\n    public static function get($params)\n    {\n        $gateway = new self::$_artifactGateway();\n        $row = $gateway->fetchArtifact($params);\n        return Model_Artifact::factory($row);        \n    }\n\n    public static function getCollection($params = null)\n    {\n        $gateway = new self::$_artifactGateway();\n        $rowset = $gateway->fetchArtifacts($params);\n        $data = array(\n            'data' => $rowset,\n            'modelClass' => Model_Artifact::class\n        );\n        return new self::$_collectionClass($data);\n    }\n}\n\n// Usage:\n// $artifact = Model_Artifact_Finder::get($params);\n// $artifactCollection = Model_Artifact_Finder::getCollection($params);