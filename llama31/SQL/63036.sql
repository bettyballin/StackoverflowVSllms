UPDATE wp_posts\nSET post_content = REPLACE(LOWER(post_content), 'http://oldurl.com', 'http://newurl.com');