php > $tidy = new tidy();\nphp > $repaired = $tidy->repairString("<foo>I <3 Philadelphia</foo>", array("input-xml"=>1));\nphp > print($repaired);\n<foo>I &lt;3 Philadelphia</foo>\nphp > $el = new SimpleXMLElement($repaired);