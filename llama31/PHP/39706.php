use GuzzleHttp\Client;\n\n$client = new Client();\n$client->getAsync('http://internal-IP/userTracker.php?Name=UserName&Page=...')->wait(false);