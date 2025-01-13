function remove_custom_comments($template) {\n    // Define the custom comment pattern\n    $pattern = '/<%--(.*?)--%>/s';\n    \n    // Remove the custom comments\n    $template = preg_replace($pattern, '', $template);\n    \n    return $template;\n}\n\n// Example usage\n$template = file_get_contents('path/to/your/template.html');\n$template = remove_custom_comments($template);\n\n// Output or further process the template\necho $template;