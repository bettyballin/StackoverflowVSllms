$url = str_replace(' ', '-', $url);\n$url = preg_replace('/[^a-zA-Z0-9-]/', '', $url);