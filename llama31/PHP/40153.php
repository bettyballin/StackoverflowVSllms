public function indexAction()\n{\n    // your action code here...\n\n    // Add RSS link to the head section\n    $this->view->headLink()->appendAlternate(\n        'https://example.com/rss', \n        'application/rss+xml', \n        'RSS Feed'\n    );\n}