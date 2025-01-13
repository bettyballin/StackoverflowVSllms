$countries = array('USA', 'Canada', 'UK', 'Germany', 'France', 'Australia', 'India', 'China', 'Japan'); // add more countries as needed\n\n$total_zces = 0;\n\nforeach ($countries as $country) {\n    $url = "http://www.zend.com/store/education/certification/yellow-pages.php?country=$country";\n    $html = file_get_contents($url);\n    $dom = new DOMDocument();\n    @$dom->loadHTML($html);\n    $xpath = new DOMXPath($dom);\n    $zces = $xpath->query('//table[@class="yellow-pages-table"]//tr')->count();\n    $total_zces += $zces;\n}\n\necho "Estimated number of ZCEs worldwide: $total_zces";