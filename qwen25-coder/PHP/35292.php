<?php\nrequire 'vendor/autoload.php';\n\nuse PhpOffice\PhpSpreadsheet\IOFactory;\nuse PhpOffice\PhpSpreadsheet\Spreadsheet;\n\n$spreadsheet = new Spreadsheet();\n$sheet = $spreadsheet->getActiveSheet();\n\n// Set column names\n$colNames = ['Foo', 'Bar'];\n$sheet->fromArray([$colNames], NULL, 'A1');\n\n$rowNumber = 2; // Starting from row 2\nfor ($i = 1; $i <= 10; $i++) {\n    $row = ["foo $i", "bar $i"];\n    $sheet->fromArray([$row], NULL, 'A' . $rowNumber);\n    $rowNumber++;\n}\n\nheader('Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');\nheader('Content-Disposition: attachment;filename="test.xlsx"');\nheader('Cache-Control: max-age=0');\n\n$writer = IOFactory::createWriter($spreadsheet, 'Xlsx');\n$writer->save('php://output');\nexit;