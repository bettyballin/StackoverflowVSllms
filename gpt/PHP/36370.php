class StoreController {\n       public function __construct() {\n           $this->validateSubdomain();\n       }\n\n       private function validateSubdomain() {\n           $subdomain = $_SERVER['HTTP_HOST'];\n           $subdomain = explode('.', $subdomain)[0];\n           // Validate against your user/shop database\n           if (!$this->isValidSubdomain($subdomain)) {\n               die('Invalid store');\n           }\n       }\n\n       private function isValidSubdomain($subdomain) {\n           // Placeholder for actual validation logic, e.g., database lookup\n           return true; // Replace with actual validation\n       }\n\n       public function defaultAction() {\n           // Default action for the store controller\n       }\n\n       // Other actions...\n   }