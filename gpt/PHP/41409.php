$fileName = "Gibt es eine schö(&#59;)ne Offroadstrecke? (;)";\n$decodedFileName = html_entity_decode($fileName, ENT_QUOTES | ENT_HTML401, 'UTF-8');\necho $decodedFileName;