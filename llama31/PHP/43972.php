interface iVendor {\n    public function __construct($vendors_no = null);\n    public function getName();\n    public function getVendors_no();\n    public function getZip();\n    public function getCountryCode();\n    public function setName($name);\n    public function setVendors_no($vendors_no);\n    public function setZip($zip);\n    public function setCountryCode($countryCode);\n}\n\nabstract class Vendor implements iVendor {\n    protected $vendors_no;\n\n    public function __construct($vendors_no = null) {\n        $this->vendors_no = $vendors_no;\n    }\n\n    // implement other iVendor methods\n}\n\ninterface iShipper extends iVendor {\n    public function __construct($vendors_no = null, $shipment = null);\n    public function getTransitTime($shipment = null);\n    public function getTransitCost($shipment = null);\n    public function getCurrentShipment();\n    public function setCurrentShipment($shipment);\n    public function getStatus($shipment = null);\n}\n\nclass FedEx extends Vendor implements iShipper {\n    private $shipment;\n\n    public function __construct($vendors_no = null, $shipment = null) {\n        parent::__construct($vendors_no);\n        $this->shipment = $shipment;\n    }\n\n    // implement iShipper methods\n}