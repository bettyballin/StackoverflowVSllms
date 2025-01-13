$html = '<a href="1.html" href="2.html">Link</a>';\n\n$dom = new DOMDocument();\n$dom->loadHTML($html);\n$xpath = new DOMXPath($dom);\n\n$attributes = $xpath->query('./@href', $dom->getElementsByTagName('a')->item(0));\n\n$lastAttribute = $attributes->item($attributes->length - 1);\n\necho $lastAttribute->nodeValue; // outputs: 2.html