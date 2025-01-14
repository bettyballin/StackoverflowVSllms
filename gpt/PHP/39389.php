function simplexml_to_array($xml) {\n    if (is_object($xml) && get_class($xml) == 'SimpleXMLElement') {\n        $xml = get_object_vars($xml);\n    }\n  \n    if (is_array($xml)) {\n        foreach ($xml as $key => $value) {\n            $xml[$key] = simplexml_to_array($value);\n        }\n    }\n  \n    return $xml;\n}\n\n// Convert the SimpleXML object to an array\n$responseArray = simplexml_to_array($response);\n\n// Print the array to see the structure\nprint_r($responseArray);