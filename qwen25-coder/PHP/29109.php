$feed = Zend_Feed::import('http://rss.exemple.com/feed');\n\nif ($feed instanceof Zend_Feed_Rss) {\n    // Check for specific elements to determine the version\n    $xmlContent = simplexml_load_string($feed->saveXml());  // Convert feed object to XML string and load it into SimpleXMLElement\n\n    if (isset($xmlContent->channel->generator)) {  // RSS 2.0 often has a generator tag\n        echo "RSS 2.0";\n    } else if (isset($xmlContent->channel->image['url'])) {  // More checks can be inserted here depending on specific items that differentiate the versions\n        echo "RSS 0.92";\n    } else {\n        echo "Unknown RSS version";\n    }\n} else {\n    echo "Not an RSS feed or unsupported type.";\n}