<?php\n$html = '<table border="1"><tr><th>Header 1</th><th>Header 2</th></tr><tr><td>Data 1</td><td>Data 2</td></tr></table>';\n\n$imagick = new Imagick();\n$imagick->readImageBlob($html);\n$imagick->setImageFormat('png');\n\n// Output the image\nheader('Content-Type: image/png');\necho $imagick;\n?>