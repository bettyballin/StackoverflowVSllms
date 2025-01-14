<?php\n    $xmldoc = new DOMDocument();\n    $xmldoc->load('sample.xml');\n\n    $xpathvar = new Domxpath($xmldoc);\n\n    // Query to select lemonade elements where supplier attribute is "mother"\n    $queryResult = $xpathvar->query('//lemonade[@supplier="mother"]/price');\n    foreach($queryResult as $result) {\n        echo $result->textContent . "\n";\n    }\n\n    // Query to select lemonade elements where id attribute is "1"\n    $queryResult = $xpathvar->query('//lemonade[@id="1"]/price');\n    foreach($queryResult as $result) {\n        echo $result->textContent . "\n";\n    }\n?>