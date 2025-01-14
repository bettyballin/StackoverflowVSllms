// Centralized CMS Configuration Example\nclass CMS {\n    protected $db;\n    protected $siteId;\n\n    public function __construct($siteId) {\n        $this->siteId = $siteId;\n        $this->db = new PDO("mysql:host=localhost;dbname=cms_core", "username", "password");\n    }\n\n    public function createSite($siteName) {\n        // Logic to create new site\n        // Create new database, web root, etc.\n    }\n\n    public function getSiteContent($siteId) {\n        // Logic to get site-specific content\n    }\n\n    public function updateSiteContent($siteId, $content) {\n        // Logic to update site-specific content\n    }\n}\n\n// Super User Example\n$cms = new CMS('super_user');\n$cms->createSite('new_customer_site');