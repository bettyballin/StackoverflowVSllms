function my_plugin_parse_request(&$wp) {\n    // Check if the request is for 'foo' or any subpage thereof\n    if (isset($wp->query_vars['name']) && $wp->query_vars['name'] === 'foo') {\n        // Optionally check further for additional path segments\n        if (!empty($wp->matched_rule)) {\n            $path_pieces = explode('/', trim($wp->matched_rule, '/'));\n            if ($path_pieces[0] === 'foo') {\n                // Handle the request\n                my_plugin_handle_request();\n                \n                // Set public query variable to false to avoid 404 response\n                $wp->public_query_vars = array();\n                $wp->query_vars['error'] = 404;\n                unset($wp->query_vars['name']);\n                status_header(200);\n                nocache_headers();\n\n                // Prevent further queries\n                add_action('template_redirect', function() {\n                    exit; // Exit to stop template rendering\n                });\n            }\n        }\n    }\n}\n\nfunction my_plugin_handle_request() {\n    // Your handling logic here\n    echo 'Handling request for a foo subpage dynamically!';\n}\n\nadd_action('parse_request', 'my_plugin_parse_request');