require 'vendor/autoload.php';\n\nuse getID3;\nuse getid3_writetags;\n\nfunction setAlbumArt($mp3File, $imageFile, $outputFile)\n{\n    $getID3 = new getID3;\n    $tagwriter = new getid3_writetags;\n    \n    $tagwriter->filename = $mp3File;\n    $tagwriter->tagformats = array('id3v2.3');\n    \n    $tagwriter->overwrite_tags = true;\n    $tagwriter->remove_other_tags = false;\n    \n    $tagwriter->tag_encoding = 'UTF-8';\n    \n    $TagData = array(\n        'attached_picture' => array(\n            array(\n                'data'          => file_get_contents($imageFile),\n                'picturetypeid' => 0x03,\n                'description'   => 'cover',\n                'mime'          => mime_content_type($imageFile)\n            )\n        )\n    );\n\n    $tagwriter->tag_data = $TagData;\n\n    if ($tagwriter->WriteTags()) {\n        copy($mp3File, $outputFile);\n        echo 'Successfully wrote tags<br>';\n    } else {\n        echo 'Failed to write tags!<br>' . implode('<br><br>', $tagwriter->errors);\n    }\n}\n\n$mp3File = 'path/to/your/mp3file.mp3';\n$imageFile = 'path/to/your/coverimage.jpg';\n$outputFile = 'path/to/your/outputfile.mp3';\n\nsetAlbumArt($mp3File, $imageFile, $outputFile);