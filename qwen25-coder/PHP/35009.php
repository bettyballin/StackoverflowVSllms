// Create file and exit;\n$filename = $file."_".date("Y-m-d_H-i",time());\nheader("Content-type: text/csv; charset=utf-8");\nheader("Content-disposition: attachment; filename=".$filename.".csv");\n\n// Ensure the data is UTF-8 encoded\necho "\xEF\xBB\xBF"; // UTF-8 BOM for Excel compatibility\necho $csv_output;