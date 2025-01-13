// Hook into the post save action to check and set category thumbnail\nfunction set_category_thumbnail_on_post_save($post_id) {\n    // Check if this is a valid post type\n    if (get_post_type($post_id) != 'post') {\n        return;\n    }\n\n    // Get the post categories\n    $categories = wp_get_post_categories($post_id);\n    if (empty($categories)) {\n        return;\n    }\n\n    // Get the first image in the post content\n    $post = get_post($post_id);\n    preg_match_all('/<img[^>]+src=["\']([^"\']+)["\']/', $post->post_content, $matches);\n    if (empty($matches[1])) {\n        return;\n    }\n\n    $first_image_url = $matches[1][0];\n\n    // Assign the first image as the category thumbnail\n    foreach ($categories as $category_id) {\n        $current_thumbnail = get_term_meta($category_id, 'category_thumbnail', true);\n        if (empty($current_thumbnail)) {\n            update_term_meta($category_id, 'category_thumbnail', esc_url($first_image_url));\n        }\n    }\n}\nadd_action('save_post', 'set_category_thumbnail_on_post_save');