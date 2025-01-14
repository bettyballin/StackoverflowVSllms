<?php\n// Turn off all caching mechanisms\nheader("Expires: Mon, 26 Jul 1997 05:00:00 GMT");\nheader("Cache-Control: no-store, no-cache, must-revalidate"); // HTTP/1.1\nheader("Pragma: no-cache"); // backward compatibility with IE\n\n// Assuming you're generating a PNG or Excel file\nif (isset($_REQUEST['type']) && $_REQUEST['type'] == 'png') {\n    header('Content-Type: image/png');\n    // Your code to generate the PNG chart\n} elseif (isset($_REQUEST['type']) && $_REQUEST['type'] == 'excel') {\n    header('Content-Type: application/vnd.ms-excel');\n    // Your code to generate the Excel file\n}\n\n// Ensure the filename is always unique if data changes, or append a timestamp or hash\n$filename = "chart_" . time() . ".png"; // Example for PNG\nheader("Content-Disposition: attachment; filename=\"" . $filename . "\"");