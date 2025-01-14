class Lang {\n    private static $instance = null;\n    private $currentLanguage = 'English';\n    private $translations = [];\n\n    // Private constructor to prevent direct instantiation\n    private function __construct() {}\n\n    public static function getInstance(): Lang {\n        if (self::$instance === null) {\n            self::$instance = new Lang();\n        }\n        return self::$instance;\n    }\n\n    public function setLanguage(string $language): void {\n        $this->currentLanguage = $language;\n        // Load translations here based on the language\n        $this->loadTranslations($language);\n    }\n\n    private function loadTranslations(string $language): void {\n        // Example: Load translations from a file or database into $this->translations\n        switch ($language) {\n            case 'Czeck':\n                $this->translations = [\n                    'Source input' => 'Zdroj vstupního',\n                ];\n                break;\n            default:\n                $this->translations = [];\n        }\n    }\n\n    public function setCurrent(string $section): void {\n        // Load translations for a specific section\n        // This can be further developed to load different translation files/arrays\n        $this->loadTranslations($this->currentLanguage, $section);\n    }\n\n    public static function _translate(string $key): string {\n        return self::getInstance()->getTranslation($key);\n    }\n\n    private function getTranslation(string $key): string {\n        if (array_key_exists($key, $this->translations)) {\n            return $this->translations[$key];\n        }\n        return $key; // Return the key itself if not found\n    }\n}\n\n// Create a global _() function to use as a shortcut\nfunction _(string $key): string {\n    return Lang::_translate($key);\n}\n\n// Usage example\n$lang = Lang::getInstance();\n$lang->setLanguage('Czeck');\nprint _('Source input'); // output: "zdroj vstupního"