$dompdf = new Dompdf();\n   $dompdf->loadHtml($html);\n   $dompdf->setPaper('A4', 'portrait');\n   $dompdf->render();\n   $dompdf->stream("document.pdf", array("Attachment" => false));