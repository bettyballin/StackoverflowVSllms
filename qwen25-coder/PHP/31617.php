abstract class LP_Model_Abstract {\n    protected $_row = null;\n    protected $_data = array();\n\n    public function __construct($row = null) {\n        $this->_row = $row;\n    }\n\n    // ... other methods ...\n}\n\nabstract class LP_Model_Factory_Abstract extends LP_Model_Abstract {}\n\nclass Model_Artifact extends LP_Model_Factory_Abstract {\n    protected static $_artifactGateway = 'Model_Table_Artifact';\n\n    public function factory($row) {\n        $class = 'Model_Artifact_' . $row->fileType;\n        return new $class($row);\n    }\n}\n\n// Finder class for Model_Artifact\nclass ArtifactFinder {\n    private $gateway;\n\n    public function __construct(IGateway $gateway) {\n        $this->gateway = $gateway;\n    }\n\n    public function create($params) {\n        // Logic to create an artifact instance\n    }\n\n    public function get($params) {\n        $row = $this->gateway->fetchArtifact($params);\n        return (new Model_Artifact)->factory($row);\n    }\n\n    public function getCollection($params) {\n        $rowset = $this->gateway->fetchArtifacts($params);\n        return new LP_Model_Collection_Factory(['data' => $rowset, 'modelClass' => 'Model_Artifact']);\n    }\n}\n\n// Interface for gateway\ninterface IGateway {\n    public function fetchArtifact($params);\n    public function fetchArtifacts($params = null);\n}