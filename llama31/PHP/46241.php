require_once('tcpdf/tcpdf.php');\n\n$pdf = new TCPDF(PDF_PAGE_ORIENTATION, PDF_UNIT, PDF_PAGE_FORMAT, true, 'UTF-8', false);\n\n$pdf->SetCreator(PDF_CREATOR);\n$pdf->SetAuthor('Your Name');\n$pdf->SetTitle('Your PDF Title');\n\n$pdf->AddPage();\n\n// Your HTML content here\n$html = '<h1>Hello World!</h1>';\n\n$pdf->writeHTML($html, true, false, true, false, '');\n\n$pdf->Output('example.pdf', 'I');