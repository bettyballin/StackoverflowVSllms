$html = new HTML;\n$html->tag('html');\n    $html->tag('head');\n    $html->close();\n    $html->tag('body');\n        $html->tag('h1');\n        $html->text('Hello World!');\n        $html->close();\n    $html->close();\n$html->close();\necho $html;