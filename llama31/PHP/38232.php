require 'sphinxapi.php';\n\n$cl = new SphinxClient();\n$cl->SetServer('localhost', 9312);\n$cl->SetMatchMode(SPH_MATCH_EXTENDED2);\n\n$query = 'search query';\n$result = $cl->Query($query, 'my_index');\n\nprint_r($result);