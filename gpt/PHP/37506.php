class Template {\n    private $vars = [];\n\n    public function set($key, $value) {\n        $this->vars[$key] = $value;\n    }\n\n    public function render($template) {\n        extract($this->vars);\n        ob_start();\n        include($template);\n        return ob_get_clean();\n    }\n}