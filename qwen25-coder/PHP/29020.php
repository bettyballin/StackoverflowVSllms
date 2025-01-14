<?php\nrequire 'vendor/autoload.php';\n\nuse Dompdf\Dompdf;\n\n// Initialize Dompdf\n$options = new Dompdf\Options();\n$options->set('defaultFont', 'Courier');\n$dompdf = new Dompdf($options);\n\n// Load the HTML content from your invoice URL\n$url = "http://example.com/invoices/3333";\n$htmlContent = file_get_contents($url);\n\n// Set the HTML content\n$dompdf->loadHtml($htmlContent);\n\n// (Optional) Setup the paper size and orientation\n$dompdf->setPaper('A4', 'portrait');\n\n// Render the HTML as PDF\n$dompdf->render();\n\n// Output the generated PDF to Browser\n$dompdf->stream("invoice.pdf", array("Attachment" => false));\n?>