<?php\n/*\nPlugin Name: Custom Preview Link Redirect\nDescription: Redirects the Preview links in WordPress to custom PHP files.\nVersion: 1.0\nAuthor: Your Name\n*/\n\nfunction my_custom_preview_url($url, $post) {\n    // Define a mapping of post IDs to your custom file paths\n    $custom_links = array(\n        2 => home_url('/contact.php'), // Assuming page ID 2 corresponds to contact.php\n        8 => home_url('/about.php')   // Assuming page ID 8 corresponds to about.php\n    );\n\n    if (isset($custom_links[$post->ID])) {\n        return $custom_links[$post->ID];\n    }\n\n    return $url;\n}\n\nadd_filter('preview_post_link', 'my_custom_preview_url', 10, 2);\n\n?>