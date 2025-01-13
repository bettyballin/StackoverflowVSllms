<?php\nfunction download_page($path){\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL,$path);\n    curl_setopt($ch, CURLOPT_FAILONERROR,1);\n    curl_setopt($ch, CURLOPT_FOLLOWLOCATION,1);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER,1);\n    curl_setopt($ch, CURLOPT_TIMEOUT, 15);\n    $retValue = curl_exec($ch);          \n    curl_close($ch);\n    return $retValue;\n}\n\n$sXML = download_page('http://alanstorm.com/atom');\n$oXML = new SimpleXMLElement($sXML);\n\nforeach($oXML->entry as $oEntry){\n    echo $oEntry->title . "\n";\n}