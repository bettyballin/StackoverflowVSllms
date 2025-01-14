require 'vendor/autoload.php';\n\nuse NumberFormatter\NumberFormatter;\n\n$text = "iPhone has two hundred and thirty thousand seven hundred and eighty three apps";\n$formatter = new NumberFormatter();\n$formattedText = $formatter->format($text);\n\necho $formattedText; // Outputs: iPhone has 230783 apps