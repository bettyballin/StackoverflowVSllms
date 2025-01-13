$pdf = Zend_Pdf::load('path/to/example.pdf');\n$text = '';\nforeach ($pdf->pages as $page) {\n    $text .= $page->extractText();\n}\n\n$index = Zend_Search_Lucene::create('path/to/index');\n$doc = new Zend_Search_Lucene_Document();\n$doc->addField(Zend_Search_Lucene_Field::text('content', $text));\n$index->addDocument($doc);\n$index->commit();