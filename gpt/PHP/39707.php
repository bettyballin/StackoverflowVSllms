<?php\n\nclass tattler_stats {\n    public function __construct($request) {\n        $param = $request['menu'];\n        $this->run($param);\n    }\n\n    public function run($param) {\n        $this->connect();\n        $this->showMenu($param);\n    }\n\n    private function connect() {\n        // database connection logic\n    }\n\n    private function showMenu($param) {\n        // display menu logic\n    }\n}\n\n?>