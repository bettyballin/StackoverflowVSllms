<?php\n\nfunction generateHtml($indent = '') {\n    ob_start(); // Start output buffering\n\n    echo "$indent<div class=\"foo\">\n";\n    echo "$indent    <?php\n";\n    echo "$indent        \$fooHeader();\n";\n    echo "$indent        \$fooBody();\n";\n    echo "$indent        \$fooFooter();\n";\n    echo "$indent    ?>\n";\n    echo "$indent</div>\n";\n\n    $output = ob_get_clean(); // Capture the buffered output\n\n    return $output;\n}\n\n// Example usage\n$indentedHtml = generateHtml('    '); // Indent with four spaces\necho $indentedHtml;\n\n?>