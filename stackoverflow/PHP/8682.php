$client   = $wsdl->getProxy();\n// don't wrap it into another array.\n// $params = array('USZip' => $zip);\n$response = $client->GetInfoByZIP($zip);\nvar_dump( $response );