// Make sure this file is local to the system the script is running on.\n// If it's a "url://" path, you can run into url_fopen problems.\n$lines = file('english.php');\n\n// No need to reinitialize each time.\n$matches = array();\n\n$lang = array();\nforeach($lines as $line) {\n    if (preg_match('/DEFINE\(\'([^\']*)\',\s*\'([^\\\\\']*(?:\\.[^\\\\\']*)*)\'\);/i', $line, $matches)) {\n        $lang[$matches[1]] = $matches[2];\n    }\n}