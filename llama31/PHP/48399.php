$html = file_get_contents('your_html_file.html');\n$doc = new DOMDocument();\n$doc->loadHTML($html);\n$xpath = new DOMXPath($doc);\n\n$interestingBoxes = $xpath->query('//div[@id="interestingbox"]');\nforeach ($interestingBoxes as $box) {\n    $details = $box->getElementsByTagName('div')->item(0);\n    $content1 = $details->getElementsByTagName('div')->item(0)->nodeValue;\n    $content2 = $details->getElementsByTagName('div')->item(1)->nodeValue;\n    echo "Content 1: $content1\n";\n    echo "Content 2: $content2\n";\n}