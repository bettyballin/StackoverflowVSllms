function getIsCrawler($userAgent) {\n    $crawlers = 'Google|msnbot|Rambler|Yahoo|AbachoBOT|accoona|' .\n                'AcioRobot|ASPSeek|CocoCrawler|Dumbot|FAST-WebCrawler|' .\n                'GeonaBot|Gigabot|Lycos|MSRBOT|Scooter|AltaVista|IDBot|eStyle|Scrubby';\n    $isCrawler = (preg_match("/$crawlers/i", $userAgent) > 0);\n    return $isCrawler;\n}\n\n$isCrawler = getIsCrawler($_SERVER['HTTP_USER_AGENT']);\n\nif ($isCrawler) {\n    header('Location: http://www.website.com/sitemap.xml');\n    exit;\n} else {\n    echo "not crawler!";\n}