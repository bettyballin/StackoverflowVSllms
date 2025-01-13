<?php\n\n$params = array(\n    'color' => $_GET['color'],\n    'number' => $_GET['number']\n);\n\n$xsl = new DOMDocument;\n$xsl->load('mystylesheet.xsl');\n\n$xml = new DOMDocument;\n$xml->load('mydocument.xml');\n\n$proc = new XSLTProcessor;\n$proc->importStyleSheet($xsl); // attach the xsl rules\n\nforeach ($params as $key => $val)\n    $proc->setParameter('', $key, $val);\n\necho $proc->transformToXML($xml);