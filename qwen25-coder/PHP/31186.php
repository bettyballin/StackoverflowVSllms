require 'vendor/autoload.php'; // Make sure to install via composer: `composer require elasticsearch/elasticsearch`\nuse Elasticsearch\ClientBuilder;\n\n$client = ClientBuilder::create()->build();\n\n$indexParams = [\n    'index' => 'forum_posts',\n    'body'  => [\n        'mappings' => [\n            'properties' => [\n                'post_text'   => ['type' => 'text'],\n                'post_subject'=> ['type' => 'keyword']\n            ]\n        ]\n    ]\n];\n$client->indices()->create($indexParams);