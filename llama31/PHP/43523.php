use PHPCrawler\PHPCrawler;\n\n$crawler = new PHPCrawler();\n$crawler->setRootUrl('http://example.com');\n$crawler->setSavePath('/path/to/static/site');\n$crawler->crawl();