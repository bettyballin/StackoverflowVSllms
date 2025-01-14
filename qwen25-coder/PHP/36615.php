require 'vendor/autoload.php';\n\n   use PhpOffice\PhpSpreadsheet\Spreadsheet;\n   use PhpOffice\PhpSpreadsheet\Writer\Xlsx;\n\n   $spreadsheet = new Spreadsheet();\n   $sheet = $spreadsheet->getActiveSheet();\n   $sheet->setCellValue('A1', 'Hello World !');\n\n   $writer = new Xlsx($spreadsheet);\n   $filename = 'hello world.xlsx';\n   header('Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');\n   header('Content-Disposition: attachment; filename="' . urlencode($filename) . '"');\n   $writer->save('php://output');