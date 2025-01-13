<?php\n\n$doc = new DOMDocument; \n$doc->load('theFile.xml');\n\n$thedocument = $doc->documentElement;\n\n//this gives you a list of the messages\n$list = $thedocument->getElementsByTagName('message');\n\n//figure out which ones you want -- assign it to a variable (ie: $nodeToRemove )\n$nodeToRemove = null;\nforeach ($list as $domElement){\n  $attrValue = $domElement->getAttribute('time');\n  if ($attrValue == 'VALUEYOUCAREABOUT') {\n    $nodeToRemove = $domElement; //will only remember last one- but this is just an example :)\n  }\n}\n\n//Now remove it.\nif ($nodeToRemove != null)\n$thedocument->removeChild($nodeToRemove);\n\necho $doc->saveXML(); \n?>