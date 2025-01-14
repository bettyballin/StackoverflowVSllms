<?php\n\nrequire_once 'vendor/autoload.php';\n\nuse Highlight\Highlighter;\n\n$hl = new Highlighter();\n\n// Example code snippet in PHP\n$code = '<?php echo "Hello, world!"; ?>';\n\n// Specify the language or let GeSHi auto detect it\n$result = $hl->highlightAuto($code);\n\necho "<pre>";\necho $result->value; // echoed HTML will contain syntax highlighted code\necho "</pre>";\n\n?>