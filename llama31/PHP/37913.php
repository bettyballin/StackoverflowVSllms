// en.php (English language pack)\n$lang = array(\n    'hello' => 'Hello',\n    'goodbye' => 'Goodbye',\n);\n\n// fr.php (French language pack)\n$lang = array(\n    'hello' => 'Bonjour',\n    'goodbye' => 'Au revoir',\n);\n\n// lang.php (language loader)\nfunction load_language($lang_code) {\n    $lang_file = $lang_code . '.php';\n    if (file_exists($lang_file)) {\n        include $lang_file;\n        return $lang;\n    } else {\n        // Fallback to default language (English)\n        include 'en.php';\n        return $lang;\n    }\n}\n\n// example usage\n$lang = load_language('fr');\necho $lang['hello']; // Output: Bonjour