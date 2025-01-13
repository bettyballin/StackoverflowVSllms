require 'vendor/autoload.php';\n\nuse PhpOffice\PhpSpreadsheet\Spreadsheet;\nuse PhpOffice\PhpSpreadsheet\Reader\Xlsx;\n\n$reader = new Xlsx();\n$spreadsheet = $reader->load('example.xlsx');\n$worksheet = $spreadsheet->getActiveSheet();\n\n$data = [];\nforeach ($worksheet->getRowIterator() as $row) {\n    $rowData = [];\n    foreach ($row->getCellIterator() as $cell) {\n        $rowData[] = $cell->getValue();\n    }\n    $data[] = $rowData;\n}\n\nprint_r($data);