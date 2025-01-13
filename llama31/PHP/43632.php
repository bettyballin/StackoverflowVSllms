require_once 'Zend/Search/Lucene.php';\n\n$index = Zend_Search_Lucene::create('path/to/index');\n\n$doc = new Zend_Search_Lucene_Document();\n$doc->addField(Zend_Search_Lucene_Field::Text('title', 'Example Title'));\n$doc->addField(Zend_Search_Lucene_Field::Text('body', 'This is an example document.'));\n\n$index->addDocument($doc);\n$index->commit();