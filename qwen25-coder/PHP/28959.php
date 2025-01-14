<?php\nlibxml_use_internal_errors(true); // Suppresses the noise from malformed HTML\n\n$html = '<table>\n   <tr>\n     <td>quote1</td>\n     <td>have you trying it off and on again ?</td>\n   </tr>\n   <tr>\n     <td>quote65</td>\n     <td>You wouldn\'t steal a helmet of a policeman</td>\n   </tr>\n</table>';\n\n$dom = new DOMDocument;\n$dom->loadHTML($html);\n\n$tableRows = $dom->getElementsByTagName('tr');\n\nforeach ($tableRows as $row) {\n    $columns = $row->getElementsByTagName('td');\n    if ($columns->length == 2) {\n        echo $columns[0]->nodeValue . ':' . $columns[1]->nodeValue . "\n";\n    }\n}\n?>