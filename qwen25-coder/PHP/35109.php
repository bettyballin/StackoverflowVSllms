<?php\n$inbound = file_get_contents('php://input');\n\n$json_object = json_decode($inbound);\necho $json_object->firstName;\necho $json_object->lastName;\necho $json_object->email;\necho $json_object->deviceUUID;\n?>