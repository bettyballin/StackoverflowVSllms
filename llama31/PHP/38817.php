$xmlReader = new XMLReader();\n$xmlReader->open('XMLFILE');\n\n$itemList = array();\n$i = 0;\n\nwhile ($xmlReader->read()) {\n    if ($xmlReader->nodeType == XMLReader::ELEMENT) {\n        if ($xmlReader->localName == 'title' && $xmlReader->namespaceURI == '') {\n            $xmlReader->read();\n            $itemList[$i]['title'] = $xmlReader->value;\n        } elseif ($xmlReader->localName == 'description' && $xmlReader->namespaceURI == '') {\n            $xmlReader->read();\n            $itemList[$i]['description'] = $xmlReader->value;\n        } elseif ($xmlReader->localName == 'thumbnail' && $xmlReader->namespaceURI == 'http://search.yahoo.com/mrss/') {\n            $itemList[$i]['media:thumbnail'] = array(\n                'url' => $xmlReader->getAttribute('url'),\n                'width' => $xmlReader->getAttribute('width'),\n                'height' => $xmlReader->getAttribute('height')\n            );\n            $i++;\n        }\n    }\n}