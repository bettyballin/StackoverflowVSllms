add_action('parse_request', 'my_plugin_parse_request');\nfunction my_plugin_parse_request($wp) {\n    if (isset($wp->query_vars['my_plugin']) && $wp->query_vars['my_plugin'] == 'foo') {\n        // Handle the request here\n        // You can access the path using $wp->query_vars['path']\n    }\n}