<?php\n\n    // Load the XML feed from Last.fm\n    $doc = new DOMDocument();\n    $doc->load('http://ws.audioscrobbler.com/1.0/user/nathanjmassey/recenttracks.xml');\n    $arrFeeds = array();\n\n    // Parse each track from the feed\n    foreach ($doc->getElementsByTagName('track') as $node) {\n        $itemRSS = array(\n            'artist' => $node->getElementsByTagName('artist')->item(0)->nodeValue,\n            'name' => $node->getElementsByTagName('name')->item(0)->nodeValue,\n            'url' => $node->getElementsByTagName('url')->item(0)->nodeValue\n        );\n        array_push($arrFeeds, $itemRSS);\n    }\n\n?>\n\n<!-- Display each track as a link -->\n<ul>\n<?php foreach ($arrFeeds as $i => $values) { ?>\n    <li><a href="<?php echo htmlspecialchars($values['url']); ?>"><?php echo htmlspecialchars($values['artist'] . ' - ' . $values['name']); ?></a></li>\n<?php } ?>\n</ul>