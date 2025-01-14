// Define Feed Source Configuration\n$feed_source = new \stdClass();\n$feed_source->fetcher = ['plugin_key' => 'HTTPFetcher'];\n$feed_source->parser = [\n  'plugin_key' => 'SyndicationParser',\n  'config' => [],\n];\n$feed_source->processor = [\n  'plugin_key' => 'EntityProcessor',\n  'config' => [\n    'content_type' => 'YOUR_FEED_CONTENT_TYPE_MACHINE_NAME',\n    'update_existing' => TRUE,\n    'input_format' => 'filtered_html',\n    'mappings' => [\n      // Define mappings based on your RSS XML structure\n    ],\n  ],\n];