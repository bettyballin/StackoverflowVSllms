<?php\n// Load the XML file\n$xml = simplexml_load_file('path/to/your/file.xml') or die("Error: Cannot create object");\n\n// Initialize an array to hold the options\n$options = [];\n\n// Function to recursively find "album" elements with "contentnumber"\nfunction findAlbums($node, &$options) {\n    foreach ($node->album as $album) {\n        $contentnumber = (string) $album->contentnumber;\n        $title = (string) $album->title;\n        if (!empty($contentnumber) && !empty($title)) {\n            $options[] = ['contentnumber' => $contentnumber, 'title' => $title];\n        }\n    }\n    foreach ($node->collection as $collection) {\n        findAlbums($collection, $options);\n    }\n}\n\n// Start the recursive search\nfindAlbums($xml, $options);\n\n// Generate the HTML select element\necho '<select name="select" id="select">';\nforeach ($options as $option) {\n    echo '<option value="' . htmlspecialchars($option['contentnumber'], ENT_QUOTES, 'UTF-8') . '">' . htmlspecialchars($option['title'], ENT_QUOTES, 'UTF-8') . '</option>';\n}\necho '</select>';\n?>