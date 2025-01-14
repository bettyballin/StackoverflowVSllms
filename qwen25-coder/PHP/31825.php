class View\n{\n    private $_vars = array();\n    private $_file;\n\n    public function __construct($file)\n    {\n        $this->_file = 'views/' . $file . '.php';\n    }\n\n    public function set($var, $value = null)\n    {\n        if (is_array($var)) {\n            $this->_vars = array_merge($var, $this->_vars);\n        } else {\n            $this->_vars[$var] = $value;\n        }\n\n        return $this;\n    }\n\n    // Accept variables as a parameter\n    public function output(array $parentVars = [])\n    {\n        // Merge parent variables with current variables\n        $mergedVars = array_merge($this->_vars, $parentVars);\n        \n        if (count($mergedVars)) {\n            extract($mergedVars, EXTR_REFS);\n        }\n        require($this->_file);\n    }\n\n    public static function factory($file)\n    {\n        return new self($file);\n    }\n}\n\n// test.php (top level view)\n<html>\n<body>\nHey <?=$name?>! This is <?=$adj?>!\n<?php \n    // Pass current variables to the embedded view\n    View::factory('embed')->output(get_defined_vars());\n?>\n</body>\n</html>\n\n// embed.php (embedded in test.php)\n<html>\n<body>\nHey <?=$name?>! This is an embedded view file!!\n</body>\n</html>\n\n// Code:\n$vars = array(\n    'name' => 'ryan',\n    'adj' => 'cool'\n);\nView::factory('test')->set($vars)->output();