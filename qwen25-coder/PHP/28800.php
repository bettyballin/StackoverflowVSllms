function removeAccents($string) {\n    // Normalize the string to decompose characters into their base characters and diacritics\n    $decomposed = Normalizer::normalize($string, Normalizer::FORM_D);\n    \n    // Use a regular expression to remove the diacritical marks (combining characters)\n    return preg_replace('/\p{Mn}/u', '', $decomposed);\n}\n\n$input = "Fóø Bår";\n$output = removeAccents($input);\n\nprint($output); // Outputs: Foo Bar