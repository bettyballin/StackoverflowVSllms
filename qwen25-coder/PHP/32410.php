$formatter = new NumberFormatter('de_DE',  NumberFormatter::PATTERN_DECIMAL);\n   echo $formatter->format(1234567.89); // Outputs: 1.234.567,89