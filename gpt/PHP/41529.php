// In your child theme's functions.php\nfunction my_custom_enqueue_scripts() {\n    wp_enqueue_style('parent-style', get_template_directory_uri() . '/style.css');\n}\nadd_action('wp_enqueue_scripts', 'my_custom_enqueue_scripts');