$options = [\n    "http" => [\n        "header" => "Cache-Control: no-cache, no-store, must-revalidate\r\n"\n    ]\n];\n$context = stream_context_create($options);\n$fileContents = file_get_contents('http://www.iac.ethz.ch/php/chn_meteo_roof/', false, $context);\n\nif ($fileContents === false) {\n    // Handle error\n} else {\n    // Process the file contents\n    echo $fileContents;\n}