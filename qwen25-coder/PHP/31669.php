<?php\nrequire_once('path/to/simplepie/autoloader.php');\n\n$feed = new SimplePie();\n$feed->set_feed_url('https://example.com/rss');\n$feed->enable_cache(false); // Disable caching if you want the latest data every time\n$feed->init();\n$feed->handle_content_type();\n\nforeach ($feed->get_items() as $item) {\n    echo 'Title: ', $item->get_title(), PHP_EOL;\n    echo 'Link: ', $item->get_link(), PHP_EOL;\n    echo 'Date: ', $item->get_date('j F Y, g:i a'), PHP_EOL;\n    echo 'Description: ', $item->get_description(), PHP_EOL, PHP_EOL;\n}\n?>