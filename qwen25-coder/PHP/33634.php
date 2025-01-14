function custom_wp_list_categories($output) {\n    // Use preg_replace_callback to insert id and title attributes into each list item.\n    return preg_replace_callback(\n        '|<li class="[^"]*">(.+?)</a>|',\n        function ($matches) {\n            $category_details = url_to_postid(parse_url($matches[1], PHP_URL_PATH));\n            \n            // Fetch category object to get ID and title\n            if ('/category/' == substr(parse_url($matches[1], PHP_URL_PATH), 0, 10)) { // Adjust this line based on your category base\n                $category_base = str_replace(home_url() . '/category/', '', parse_url($matches[1], PHP_URL_PATH));\n                $category_info = get_category_by_slug($category_base);\n            } else {\n                $category_info = get_category_by_path(parse_url($matches[1], PHP_URL_PATH)); // Adjust this line based on your category structure\n            }\n\n            if ($category_info) {\n                return sprintf(\n                    '<li id="cat-%d" class="%s" title="%s">%s</li>',\n                    esc_attr($category_info->term_id),\n                    esc_attr('wp-post'),\n                    esc_attr($category_info->name),\n                    str_replace('</a>', ' id="cat-' . esc_attr($category_info->term_id) . '" title="' . esc_attr($category_info->name) . '">' . esc_html($category_info->name) . '</a>', $matches[0])\n                );\n            }\n\n            return $matches[0];\n        },\n        $output\n    );\n}\n\nadd_filter('wp_list_categories', 'custom_wp_list_categories');