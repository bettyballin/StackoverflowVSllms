$url = "http://www.example.com/backend.php?/c=crud&m=index&t=care";\n$updated_url = str_replace("backend.php?/", "backend.php?", $url);\necho $updated_url;