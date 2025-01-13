<?php\n   require 'vendor/autoload.php';\n\n   use Dompdf\Dompdf;\n\n   // Instantiate and use the dompdf class\n   $dompdf = new Dompdf();\n\n   // Load HTML content from a URL\n   $html = file_get_contents('http://example.com/invoices/3333');\n\n   // Load the HTML content into dompdf\n   $dompdf->loadHtml($html);\n\n   // (Optional) Set paper size and orientation\n   $dompdf->setPaper('A4', 'portrait');\n\n   // Render the HTML as PDF\n   $dompdf->render();\n\n   // Output the generated PDF to Browser\n   $dompdf->stream("invoice_3333.pdf", ["Attachment" => false]);