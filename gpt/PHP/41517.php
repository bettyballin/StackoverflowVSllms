if (!mb_check_encoding($item['area'], 'ISO-8859-1')) {\n    // Handle invalid encoding, possibly log or sanitize the input\n}\n\n// Convert and add to index\n$area_utf8 = mb_convert_encoding($item['area'], 'UTF-8', 'ISO-8859-1');\n$doc->addField(Zend_Search_Lucene_Field::keyword('_area', mb_strtolower($area_utf8, 'UTF-8'), 'UTF-8'));