<?php\n// Load the HTML content\n$html = '<html>...</html>'; // Your HTML content here\n\n// Create a new DOMDocument\n$dom = new DOMDocument();\n\n// Suppress warnings due to malformed HTML\nlibxml_use_internal_errors(true);\n\n// Load the HTML into the DOMDocument\n$dom->loadHTML($html);\n\n// Restore error handling\nlibxml_clear_errors();\n\n// Create a new DOMXPath\n$xpath = new DOMXPath($dom);\n\n// Query for all SPAN elements with class="img"\n$spans = $xpath->query('//span[@class="img"]');\n\n// Initialize an array to hold the links\n$links = [];\n\n// Loop through each SPAN element\nforeach ($spans as $span) {\n    // Find the link within the SPAN element\n    $a = $span->getElementsByTagName('a')->item(0);\n\n    // If a link is found, get its href attribute\n    if ($a) {\n        $links[] = $a->getAttribute('href');\n    }\n}\n\n// Output the extracted links\nprint_r($links);\n?>