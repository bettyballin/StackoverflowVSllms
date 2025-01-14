<?php\n\nrequire_once('path/to/getid3/getid3.php');\nrequire_once('path/to/php-mp3-id3/MP3_Id3v2Tag.php');\n\ngetFile = 'path/to/your/file.mp3';\n$imageFile = 'path/to/your/image.jpg';\n\n$tagwriter = new MP3_Id3v2Tag($filePath);\nif (!$tagwriter->hasId3v2()) {\n    $tagwriter->createFrames(true, true);\n}\n\n$pictureFrame = array(\n    'data' => file_get_contents($imageFile),\n    'type' => 'Picture',\n    'description' => 'Album Cover',\n    'mime' => image_type_to_mime_type(exif_imagetype($imageFile))\n);\n\n$tagwriter->addFrames(array('APIC'=>$pictureFrame));\n$result = @$tagwriter->save();\n\nif ($result) {\n    echo "Album art added successfully.";\n} else {\n    echo "Error adding album art: " . $tagwriter->getErrorMsg();\n}\n?>