<?php\nrequire_once 'Zend/Pdf.php';\n\n$pdf = Zend_Pdf::load('blank.pdf');\n$page = $pdf->pages[0];\n$font = Zend_Pdf_Font::fontWithName(Zend_Pdf_Font::FONT_HELVETICA);\n$page->setFont($font, 12);\n$page->drawText('Hello world!', 72, 720);\n$pdf->save('zend.pdf');