foreach ($shops as $shop) {\n    $doc = new Zend_Search_Lucene_Document();\n    // Index with space\n    $doc->addField(Zend_Search_Lucene_Field::text('name', $shop['name']));\n    // Index without space as an additional field or version of that field\n    $doc->addField(Zend_Search_Lucene_Field::unIndexed(\n        'name_no_space',\n        str_replace(' ', '', $shop['name'])\n    ));\n    $index->addDocument($doc);\n}