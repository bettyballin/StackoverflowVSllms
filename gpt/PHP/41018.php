function getData() {\n       foreach (range(1, 1000) as $i) {\n           yield $i;\n       }\n   }\n\n   foreach (getData() as $value) {\n       // Process each value\n   }