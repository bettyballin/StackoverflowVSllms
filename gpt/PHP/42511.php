// Example of API usage in WooCommerce\n   $url = 'http://example.com/wp-json/wc/v3/products';\n   $options = [\n       'http' => [\n           'header' => 'Content-Type: application/json',\n           'method' => 'GET'\n       ]\n   ];\n   $context = stream_context_create($options);\n   $response = file_get_contents($url, false, $context);