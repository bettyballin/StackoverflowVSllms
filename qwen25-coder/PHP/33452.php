// Ensure IDs are being set correctly\nforeach ($media as $m) {\n    $doc = new Zend_Search_Lucene_Document();\n    $doc->addField(Zend_Search_Lucene_Field::UnIndexed('id', (string)$m->id));\n    // ... other fields ...\n    $index->addDocument($doc);\n}\n$index->commit();