$ramDirectory = Zend_Search_Lucene::createInMemory();\n    // Index documents into $ramDirectory here.\n    \n    $fsDirectory = new Zend_Search_Lucene_Storage_Directory_Filesystem('/admin/lucene');\n    $index = Zend_Search_Lucene::open($fsDirectory);\n    $index->addIndex($ramDirectory);