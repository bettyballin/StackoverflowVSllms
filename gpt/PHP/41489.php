<?php\n// Load the feed\n$feed_url = 'http://chacha102.com/feed/';\n$xml = simplexml_load_file($feed_url);\n\n// Loop through each item in the feed\nforeach ($xml->channel->item as $item) {\n    // Get the title of the entry\n    $title = (string) $item->title;\n    \n    // Get the full content (if available)\n    $namespaces = $item->getNamespaces(true);\n    $content = (string) $item->children($namespaces['content'])->encoded;\n\n    // If full content is not available, fallback to description\n    if (empty($content)) {\n        $content = (string) $item->description;\n    }\n\n    // Output the entry\n    echo "<h2>$title</h2>";\n    echo "<div>$content</div>";\n}\n?>