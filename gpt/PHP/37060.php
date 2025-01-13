public function rssAction()\n{\n    $feed = FeedUtil::getFeed($this->db);\n\n    // Set HTTP headers to manage caching\n    $this->getResponse()->setHeader('Content-Type', 'application/rss+xml; charset=utf-8');\n    $this->getResponse()->setHeader('Cache-Control', 'public, max-age=3600');\n    $this->getResponse()->setHeader('Last-Modified', gmdate('D, d M Y H:i:s') . ' GMT');\n\n    $feed->send();\n}