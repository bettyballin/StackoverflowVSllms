<?php\n$xmlString = <<<XML\n<root>\n  <thing>\n    <specs>\n      <spec1>Value1</spec1>\n      <spec3>Value3</spec3>\n      <spec2>Value2</spec2>\n    </specs>\n    <details />\n    <more_info>\n      <info1 />\n      <info2 />\n    </more_info>\n  </thing>\n</root>\nXML;\n\n$reader = new XMLReader();\n$reader->xml($xmlString); // or use $reader->open('path/to/your/file.xml');\n\nwhile ($reader->read()) {\n    if ($reader->nodeType == XMLReader::ELEMENT) {\n        switch ($reader->name) {\n            case 'spec1':\n                echo "Spec1: " . $reader->readString() . "\n";\n                break;\n            case 'spec2':\n                echo "Spec2: " . $reader->readString() . "\n";\n                break;\n            case 'spec3':\n                echo "Spec3: " . $reader->readString() . "\n";\n                break;\n        }\n    }\n}\n\n$reader->close();\n?>