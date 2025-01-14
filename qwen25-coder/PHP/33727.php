// Modify make_menu to return a string instead of echo-ing\nfunction make_menu($params)\n{\n    global $menu;\n    \n    // Start building the HTML string\n    $output = '<ul>';\n    \n    foreach ($params['parent_id'] as $menu_id => $menu_name) {\n        $output .= '<li>' . htmlspecialchars($menu_name);  // Use htmlspecialchars for security\n        if (isset($menu[$menu_id])) {\n            // Recursively call make_menu and append the returned string\n            $output .= make_menu(['parent_id' => $menu[$menu_id]]);\n        }\n        $output .= '</li>';\n    }\n    \n    $output .= '</ul>';\n    \n    return $output;  // Return the complete HTML string\n}\n\n// Register the function with Smarty\n$smarty->register_function('make_menu', 'make_menu');