$params = [\n       'index' => 'your_index',\n       'body'  => [\n           'query' => [\n               'fuzzy' => [\n                   'your_field' => [\n                       'value' => 'search_term',\n                       'fuzziness' => 'AUTO'\n                   ]\n               ]\n           ]\n       ]\n   ];\n\n   $response = $client->search($params);\n\n   print_r($response);