function fetchRows($start, $limit) {\n       for ($i = $start; $i < $start + $limit; $i++) {\n           yield getRow($i);\n       }\n   }\n\n   foreach (fetchRows(0, 1000) as $row) {\n       // Process each row\n   }