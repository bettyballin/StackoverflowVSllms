// Example of using intl extension to normalize strings\n$original = "café";\n$normalized = \Normalizer::normalize($original, \Normalizer::FORM_C);\necho $normalized; // Outputs café in normalized form