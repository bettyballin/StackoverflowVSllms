<?php\n$csvLines = [\n    'GREAT PERFORMANCES,GREAT PERFORMANCES,57744 ROUND LAKE RD,NEW YORK,NY',\n    '"GUASTAVINO\'S, INC",GUASTAVINO\'S,8250 WESTHEIMER RD,NEW YORK,NY',\n    'THE CLARKES GROUP LLC,HUGO\'S FROG BAR,915 3RD AVE,CHICAGO,IL',\n    'TRIOMPHE RESTAURANT CORP,"GEORGE\'S,JEAN",1309 E PUTNAM AVE,NEW YORK,NY'\n];\n\nforeach ($csvLines as $line) {\n    // Parse the CSV line\n    $parsedData = str_getcsv($line);\n    print_r($parsedData);\n}\n?>