add_action( 'setup_theme', function() {\n    if ( isset($_GET['theme_preview']) ) {\n        switch_theme(sanitize_text_field( $_GET['theme_preview'] ));\n    }\n});