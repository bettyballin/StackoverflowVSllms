<?php\nrequire 'vendor/autoload.php';\n\nuse RtfHtmlPhp\Html;\n\n$rtfFilePath = "mark.rtf";\n$html = Html::ConvertToHTML(file_get_contents($rtfFilePath));\n\necho $html;\n?>