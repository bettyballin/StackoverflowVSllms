<?php\n// language.php\nfunction loadTranslations($lang) {\n    $filePath = __DIR__ . "/languages/$lang.json";\n    if (file_exists($filePath)) {\n        $json = file_get_contents($filePath);\n        return json_decode($json, true);\n    }\n    return [];\n}\n\n// Set default language\n$lang = 'en';\n\n// Check if language is set in URL, cookie, or session\nif (isset($_GET['lang'])) {\n    $lang = $_GET['lang'];\n} elseif (isset($_COOKIE['lang'])) {\n    $lang = $_COOKIE['lang'];\n} elseif (isset($_SESSION['lang'])) {\n    $lang = $_SESSION['lang'];\n}\n\n// Load translations\n$translations = loadTranslations($lang);\n\n// Example usage\necho $translations['title'];\n?>