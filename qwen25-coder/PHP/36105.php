<?php\nrequire_once 'vendor/autoload.php';\n\nuse TijsVerkoyen\CssToInlineStyles\CssToInlineStyles;\n\n// Initialize the CssToInlineStyles object\n$cssToInlineStyles = new CssToInlineStyles();\n\n// Load your PHP file as a string to get HTML output\nob_start();\ninclude('yourpage.php'); // Replace with your PHP page file name\n$htmlContent = ob_get_clean();\n\n// Optionally load CSS file or use internal style blocks\n$css = file_get_contents('styles.css'); // Or manually add styles here\n\n// Convert the whole HTML with inline styles and CSS\n$htmlWithInlineStyles = $cssToInlineStyles->convert($htmlContent, $css);\n\n// Output or save the converted HTML to a static file if needed\nfile_put_contents('static_page.html', $htmlWithInlineStyles);\n\necho $htmlWithInlineStyles;\n?>