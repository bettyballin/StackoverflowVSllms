$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, "http://apple.accuweather.com/adcbin/apple/Apple_Weather_Data.asp?zipcode=EUR;PT;PO019;REGUA");\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\ncurl_setopt($ch, CURLOPT_TIMEOUT, 10); // set timeout to 10 seconds\n$xmlData = curl_exec($ch);\ncurl_close($ch);\n\n$xmlobj = simplexml_load_string($xmlData);\nprint header("Content-type: text/plain");\nprint_r($xmlobj);