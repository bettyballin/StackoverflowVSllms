function tui_cifp_templatefilter($buffer) {\n    $tui_cifp_insertvalue = get_option('tui_cifp_insertvalue');\n    if ($tui_cifp_insertvalue) {\n        $tui_cifp_insertvalue = tui_cifp_evaluate_html($tui_cifp_insertvalue);\n        // Assuming you want to replace a specific placeholder in the buffer with evaluated content\n        $buffer = str_replace('[your_placeholder]', $tui_cifp_insertvalue, $buffer);\n    }\n    return $buffer;\n}\n\nfunction tui_cifp_ob_start() {\n    ob_start('tui_cifp_templatefilter');\n}\n\nif (strpos($_SERVER['REQUEST_URI'], 'wp-admin') === false) {\n    add_action('template_redirect', 'tui_cifp_ob_start');\n}