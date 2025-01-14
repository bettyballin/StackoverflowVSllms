// view.php\n<?php\nnamespace Core;\n\nclass View extends \Core\Settings // Assuming Settings is a base class for View\n{\n    public function head()\n    {\n        include("../THEMES/" . parent::get("theme") . "/head.php");\n    }\n\n    public function foot()\n    {\n        include("../THEMES/" . parent::get("theme") . "/foot.php");\n    }\n\n    public static function index()\n    {\n        // Static method for rendering the index page\n    }\n}\n?>