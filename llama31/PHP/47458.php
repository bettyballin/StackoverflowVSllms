use Polyglot\Polyglot;\n\n$polyglot = new Polyglot();\n\n$text = "This is a sample text in English.";\n$language = $polyglot->detect($text);\n\necho "Detected language: " . $language;