// Simple validation and sanitization example\nif (isset($_GET['feed'])) {\n    $feed_type = sanitize_text_field($_GET['feed']);\n    if ($feed_type === 'rss2') {\n        do_feed('rss2');\n    } else {\n        // handle invalid feed type\n    }\n} else {\n    // handle missing feed type\n}