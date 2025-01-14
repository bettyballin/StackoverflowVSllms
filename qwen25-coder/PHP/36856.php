<?php\nsession_start();\n\n// Create a new HttpRequest instance\n$request = new HttpRequest;\n\n// Set URL and method\n$request->setUrl('http://remote.server.com/page');\n$request->setMethod(HTTP_METH_GET);\n\n// Enable cookie handling\n$request->addCookieJar(); // Use this to enable cookies\n\ntry {\n    $response = $request->send();\n    if ($response->getResponseCode() == 200) {\n        echo "Response body: " . $response->getBody();\n    } else {\n        echo "Failed with response code {$response->getResponseCode()}";\n    }\n} catch (HttpException $ex) {\n    echo $ex;\n}\n?>