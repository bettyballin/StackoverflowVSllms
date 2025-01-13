<?php\nfunction getWikipediaInfobox($title) {\n    $url = "https://en.wikipedia.org/w/api.php?action=query&titles=" . urlencode($title) . "&prop=revisions&rvprop=content&format=json&rvsection=0";\n\n    // Use file_get_contents to get the content from the URL\n    $json = file_get_contents($url);\n\n    // Decode the JSON response\n    $data = json_decode($json, true);\n\n    // Extract the page content\n    $pages = $data['query']['pages'];\n    $page = reset($pages);\n    $content = $page['revisions'][0]['*'];\n\n    // Use regular expressions to extract the Infobox content\n    preg_match('/{{Infobox(.*?)}}/s', $content, $matches);\n    if (isset($matches[0])) {\n        $infobox = $matches[0];\n    } else {\n        $infobox = "Infobox not found.";\n    }\n\n    return $infobox;\n}\n\n// Example usage\n$country = "India";  // Replace with the desired country name\n$infobox = getWikipediaInfobox($country);\necho "<pre>" . htmlentities($infobox) . "</pre>";\n?>