<?php\n// URL of the PHP page\n$url = 'http://example.com/page.php';\n\n// Use file_get_contents to get the HTML content of the PHP page\n$htmlContent = file_get_contents($url);\n\n// Save the content to a static HTML file\n$file = 'page.html';\nfile_put_contents($file, $htmlContent);\n\necho "Static HTML page created successfully.";\n?>