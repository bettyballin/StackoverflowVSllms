$post_title = 'Example Post';\n$post_content = 'This is an example post.';\n$category_id = 1;\n\n$sql = "INSERT INTO wp_posts (post_title, post_content, post_status, post_type)\n        VALUES (%s, %s, %s, %s)";\n$wpdb->query($wpdb->prepare($sql, $post_title, $post_content, 'publish', 'post'));\n$post_id = $wpdb->insert_id;\n\n$sql = "INSERT INTO wp_term_relationships (object_id, term_taxonomy_id)\n        VALUES (%d, %d)";\n$wpdb->query($wpdb->prepare($sql, $post_id, $category_id));