class PageBuilder {\n    public function writeHeader($title) {\n        ob_start();\n        include("header.php");\n        $headerContent = ob_get_clean();\n        // You can now manipulate $headerContent if needed\n        echo str_replace("{{title}}", $title, $headerContent);\n    }\n\n    public function writeLeft() {\n        ob_start();\n        include("left.php");\n        $leftContent = ob_get_clean();\n        echo $leftContent;\n    }\n}\n\n$pageBuilder = new PageBuilder();\n$pageBuilder->writeHeader("My Page Title");\n$pageBuilder->writeLeft();