$running = null;\ndo {\n    curl_multi_exec($multiHandle, $running);\n    curl_multi_select($multiHandle);\n} while ($running > 0);