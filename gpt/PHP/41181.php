<?php\n$url = "http://wapedia.mobi/sv/Gr%C3%B6t";\n$decoded_url = rawurldecode($url);\n$content = file_get_contents($decoded_url);\n\necho $content;\n?>