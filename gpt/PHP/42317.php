ob_start();\n\nforeach ($items as $item) {\n    echo '<div>' . $item . '</div>';\n}\n\n$test = ob_get_clean();