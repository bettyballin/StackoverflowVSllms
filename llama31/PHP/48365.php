use GuzzleHttp\Client;\n\n$client = new Client(['base_uri' => 'https://en.wikipedia.org/w/api.php']);\n\n// Fetch infobox data for a city\n$response = $client->get('query', [\n    'query' => [\n        'titles' => 'Beijing',\n        'prop' => 'parse',\n        'section' => '0', // infobox section\n        'format' => 'json',\n    ],\n]);\n\n$data = json_decode($response->getBody(), true);\n$infobox = $data['parse']['text']['*'];\n\n// Cache the data\n// ...\n\n// Update the data periodically\n$response = $client->get('recentchanges', [\n    'query' => [\n        'categories' => 'Countries|Cities',\n        'namespace' => '0', // main namespace\n        'limit' => '100',\n        'format' => 'json',\n    ],\n]);\n\n$changes = json_decode($response->getBody(), true);\nforeach ($changes['recentchanges'] as $change) {\n    // Update the cached data for the changed page\n    // ...\n}