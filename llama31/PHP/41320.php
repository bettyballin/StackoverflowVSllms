$locale = 'en_US'; // or 'fr_FR', 'de_DE', etc.\n$generator = new IntlDatePatternGenerator();\n$pattern = $generator->getBestPattern($locale, 'MM/DD/YYYY');\necho $pattern; // outputs: MM/DD/YYYY\n\n$locale = 'fr_FR';\n$pattern = $generator->getBestPattern($locale, 'MM/DD/YYYY');\necho $pattern; // outputs: DD/MM/YYYY