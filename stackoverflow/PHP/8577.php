$matches=array();\nif (preg_match ('/zip=([0-9]+)/', $fetched, $matches ))\n{\n    $zip=$matches[1];\n}