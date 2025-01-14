<?php\nrequire 'vendor/autoload.php';\n\nuse PhpOffice\PhpSpreadsheet\Spreadsheet;\nuse PhpOffice\PhpSpreadsheet\Writer\Xlsx;\n\n// Create a new spreadsheet object\n$spreadsheet = new Spreadsheet();\n\n// Add data to the first sheet\n$sheet1 = $spreadsheet->getActiveSheet();\n$sheet1->setTitle('Sheet 1');\n$sheet1->setCellValue('A1', 'Hello');\n$sheet1->setCellValue('B1', 'World');\n\n// Create the second sheet\n$spreadsheet->createSheet();\n$sheet2 = $spreadsheet->setActiveSheetIndex(1);\n$sheet2->setTitle('Sheet 2');\n$sheet2->setCellValue('A1', 'PhpSpreadsheet');\n$sheet2->setCellValue('B1', 'Example');\n\n// Create the third sheet\n$spreadsheet->createSheet();\n$sheet3 = $spreadsheet->setActiveSheetIndex(2);\n$sheet3->setTitle('Sheet 3');\n$sheet3->setCellValue('A1', 'Multiple');\n$sheet3->setCellValue('B1', 'Sheets');\n\n// Set the first sheet as active again\n$spreadsheet->setActiveSheetIndex(0);\n\n// Create the writer and output the file to the browser\n$writer = new Xlsx($spreadsheet);\n\nheader('Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');\nheader('Content-Disposition: attachment;filename="multiple_sheets.xlsx"');\nheader('Cache-Control: max-age=0');\n$writer->save('php://output');\nexit;\n?>