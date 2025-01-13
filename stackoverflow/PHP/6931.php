function uncompress($srcName, $dstName) {\n    $sfp = gzopen($srcName, "rb");\n    $fp = fopen($dstName, "w");\n\n    while (!gzeof($sfp)) {\n        $string = gzread($sfp, 4096);\n        fwrite($fp, $string, strlen($string));\n    }\n    gzclose($sfp);\n    fclose($fp);\n}