<?php\n$filesource = $_SERVER['HTTP_REFERER'];\n$a = fopen($filesource, "r");\n$string = fread($a, 1024);\nfclose($a);\n\nif (preg_match("/<linkto>(.*?)<\/linkto>/is", $string, $out)) {\n    $outdata = $out[1];\n} else if (preg_match("/<title>(.*?)<\/title>/is", $string, $titleOut)) {\n    $outdata = $titleOut[1];\n} else {\n    $outdata = "No linkto or title found.";\n}\n\n$outdatapart = explode(" ", $outdata);\necho $outdatapart[0];\n?>