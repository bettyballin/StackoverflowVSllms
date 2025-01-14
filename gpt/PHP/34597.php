<?php\n// URL of the page to fetch\n$pageUrl = 'http://example.com/page-with-urls.html';\n\n// Fetch the content of the page\n$htmlContent = file_get_contents($pageUrl);\n\n// Create a new DOMDocument instance\n$dom = new DOMDocument();\n\n// Suppress errors due to malformed HTML\nlibxml_use_internal_errors(true);\n\n// Load the HTML content into the DOMDocument\n$dom->loadHTML($htmlContent);\n\n// Clear the errors\nlibxml_clear_errors();\n\n// Create a new DOMXPath instance\n$xpath = new DOMXPath($dom);\n\n// Query all <a> elements with href attribute\n$links = $xpath->query("//a[@href]");\n\n// Open a file to write the URLs\n$file = fopen('urls.txt', 'w');\n\n// Iterate over the links and write each URL to the file\nforeach ($links as $link) {\n    $url = $link->getAttribute('href');\n    fwrite($file, $url . PHP_EOL);\n}\n\n// Close the file\nfclose($file);\n\necho "URLs have been written to urls.txt.\n";\n?>