$countryNames = [/* List of country names here */];\n\n$result = array_map(function($country) use ($keywords, $exceptions) {\n    $countryLower = strtolower($country);\n    if (in_array($countryLower, $keywords)) {\n        return 'The ' . ucfirst(str_replace('the ', '', $countryLower));\n    } elseif (in_array($countryLower, $exceptions)) {\n        return str_replace('the ', '', $countryLower);\n    }\n    return $country;\n}, $countryNames);\n\nprint_r($result);