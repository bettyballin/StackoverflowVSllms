$fileName = "Gibt es eine sch&ouml;ne Offroadstrecke? &copy;";\n$decodedFileName = html_entity_decode($fileName, ENT_QUOTES, 'UTF-8');\necho $decodedFileName;