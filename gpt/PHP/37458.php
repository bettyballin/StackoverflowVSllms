if ($_SERVER['HTTP_HOST'] == 'localhost') {\n    // For localhost\n    $cache_location = $_SERVER['DOCUMENT_ROOT'] . '/mysite/wp-content/cache';\n} else {\n    // For web host\n    $cache_location = $_SERVER['DOCUMENT_ROOT'] . '/wp-content/cache';\n}\n\n$feed->set_cache_location($cache_location);