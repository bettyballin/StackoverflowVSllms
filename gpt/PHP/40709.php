add_action('init', 'custom_rewrite_rules');\n   function custom_rewrite_rules() {\n       add_rewrite_rule('^foo/([^/]*)/?', 'index.php?custom_var=$matches[1]', 'top');\n       add_rewrite_rule('^foo/([^/]*)/([^/]*)/?', 'index.php?custom_var=$matches[1]&custom_var2=$matches[2]', 'top');\n   }