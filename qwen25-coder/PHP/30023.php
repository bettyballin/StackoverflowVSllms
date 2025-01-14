function getUrlContents($url) {\n    $ch = curl_init();\n    \n    curl_setopt($ch, CURLOPT_URL, $url);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1); // Return the transfer as a string\n    \n    $content = curl_exec($ch);\n    if ($content === false) {\n        throw new Exception('cURL Error: ' . curl_error($ch));\n    }\n    \n    curl_close($ch);\n    \n    return $content;\n}\n\ntry {\n    $source = getUrlContents('http://example.com');\n    echo $source;\n} catch (Exception $e) {\n    echo "Error: " . $e->getMessage();\n}