header('Cache-Control: max-age=3600, public'); // cache for 1 hour\nheader('Expires: ' . gmdate('D, d M Y H:i:s', time() + 3600) . ' GMT');