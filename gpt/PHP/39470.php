function make_request($url) {\n    return file_get_contents($url);\n}\n\n// Example usage with output\n$output = make_request('http://www.externalsite.com/script2.php?variable=45');\necho $output;