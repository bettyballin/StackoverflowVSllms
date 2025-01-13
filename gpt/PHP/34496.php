class PhpFileAndContentIterator extends IteratorIterator {\n    public function __construct($path) {\n        parent::__construct(new RecursiveIteratorIterator(new RecursiveDirectoryIterator($path)));\n    }\n\n    public function current() {\n        $filePath = parent::current()->getPathname();\n        return [$filePath => file_get_contents($filePath)];\n    }\n}\n\nclass DefinedClassDetector extends FilterIterator {\n    private $filePath;\n    private $sourceCode;\n\n    public function __construct($iterator) {\n        parent::__construct($iterator);\n    }\n\n    public function accept() {\n        [$this->filePath, $this->sourceCode] = each(parent::current());\n        return !empty($this->getDefinedClasses());\n    }\n\n    public function getDefinedClasses() {\n        $tokens = token_get_all($this->sourceCode);\n        $classes = [];\n        $namespace = '';\n        for ($i = 0; $i < count($tokens); $i++) {\n            if ($tokens[$i][0] == T_NAMESPACE) {\n                $namespace = '';\n                for ($j = $i + 1; $j < count($tokens) && $tokens[$j] != ';'; $j++) {\n                    $namespace .= is_array($tokens[$j]) ? $tokens[$j][1] : $tokens[$j];\n                }\n                $namespace .= '\\';\n            }\n            if ($tokens[$i][0] == T_CLASS) {\n                for ($j = $i + 1; $j < count($tokens); $j++) {\n                    if ($tokens[$j] == '{') {\n                        $classes[] = $namespace . $tokens[$i + 2][1];\n                        break;\n                    }\n                }\n            }\n        }\n        return $classes;\n    }\n\n    public function current() {\n        return [\n            'filePath' => $this->filePath,\n            'classes' => $this->getDefinedClasses()\n        ];\n    }\n}