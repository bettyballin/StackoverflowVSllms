$rootPath = isset($_SERVER['LOCAL_DEV']) ? $_SERVER['DOCUMENT_ROOT'] . '/mysite' : $_SERVER['DOCUMENT_ROOT'];\n$feed->set_cache_location($rootPath . '/wp-content/cache');