require('fpdf.php');\n\n   $pdf = new FPDF();\n   $pdf->AddPage();\n   $pdf->SetFont('Arial','B',16);\n   $pdf->Cell(40,10,'Hello World!');\n   $pdf->Output();