<?php\n$xmldoc = new DOMDocument();\n$xmldoc->load('sample.xml');\n\n$newAct = $_POST['activity'];\n\n$root = $xmldoc->documentElement;\n$newElement = $xmldoc->createElement('activity', $newAct);\n$root->appendChild($newElement);\n\n$xmldoc->save('sample.xml');\n\nheader('Location: index.php');\nexit;\n?>