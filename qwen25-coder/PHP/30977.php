<?php\nrequire 'vendor/autoload.php';\n\nuse PhpOffice\PhpSpreadsheet\Spreadsheet;\nuse PhpOffice\PhpSpreadsheet\Writer\Xlsx;\n\n// Database connection setup (replace with your actual credentials)\n$pdo = new PDO('mysql:host=localhost;dbname=test', 'root', '');\n\n// Fetch all data for all sheets in one query\n$stmt = $pdo->query("SELECT * FROM your_table");\n$data = [];\nwhile ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n    $data[$row['sheet_id']][] = $row;\n}\n\n$spreadsheet = new Spreadsheet();\n$spreadsheet->getActiveSheet()->setTitle('Main');\n\n// Iterate over the data to add sheets\nforeach ($data as $sheetId => $rows) {\n    if ($sheetId != 'main') {\n        $newSheet = clone $spreadsheet->getActiveSheet();\n        $newSheet->setTitle($sheetId);\n        $spreadsheet->addSheet($newSheet);\n    }\n    $activeSheet = $spreadsheet->getSheetByName($sheetId);\n\n    // Assuming data has a header row, write headers\n    $headers = array_keys(reset($rows));\n    foreach ($headers as $colIndex => $header) {\n        $activeSheet->setCellValueByColumnAndRow($colIndex + 1, 1, $header);\n    }\n\n    // Write rows of data\n    foreach ($rows as $rowIndex => $row) {\n        foreach ($row as $colIndex => $value) {\n            $activeSheet->setCellValueByColumnAndRow($colIndex + 1, $rowIndex + 2, $value);\n        }\n    }\n\n    // Add styles and formulas here as necessary\n}\n\n$writer = new Xlsx($spreadsheet);\n$filename = 'output.xlsx';\nheader('Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');\nheader("Content-Disposition: attachment; filename=\"$filename\"");\nheader('Cache-Control: max-age=0');\n\n$writer->save('php://output');\n\n// Optionally, you could save the file to disk instead:\n// $writer->save($filename);\n?>