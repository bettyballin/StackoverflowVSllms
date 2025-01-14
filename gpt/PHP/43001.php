<?php\n// Load the XML file\n$xml = simplexml_load_file('path/to/your/rss.xml');\n\n// Check if the XML was loaded successfully\nif ($xml === false) {\n    die('Error loading XML file');\n}\n\n// Iterate through each item in the RSS feed\nforeach ($xml->channel->item as $item) {\n    // Print the title\n    echo "Title: " . (string) $item->title . "\n";\n\n    // Print the description (CDATA)\n    echo "Description: " . (string) $item->description . "\n\n";\n}\n?>