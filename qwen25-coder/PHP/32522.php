function http_build_query_for_post($form_data) {\n    $post_string = '';\n\n    foreach ($form_data as $key => $value) {\n        if (is_array($value)) {\n            foreach ($value as $sub_key => $sub_value) {\n                if (is_array($sub_value)) {\n                    // Handle multi-dimensional arrays\n                    foreach ($sub_value as $deep_key => $deep_value) {\n                        $post_string .= urlencode("$key[$sub_key][$deep_key]") . '=' . urlencode($deep_value) . '&';\n                    }\n                } else {\n                    $post_string .= urlencode("$key[$sub_key]") . '=' . urlencode($sub_value) . '&';\n                }\n            }\n        } else {\n            $post_string .= urlencode($key) . '=' . urlencode($value) . '&';\n        }\n    }\n\n    // Remove the trailing "&"\n    return rtrim($post_string, '&');\n}\n\n// Example usage\n$_POST = array(\n    'one' => array('foo', 'bar'),\n    'two' => array('key' => 'something')\n);\n\n$post_data_string = http_build_query_for_post($_POST);\necho $post_data_string;