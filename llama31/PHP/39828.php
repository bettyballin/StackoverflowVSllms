$finfo = finfo_open(FILEINFO_MIME_TYPE);\n$mime_type = finfo_file($finfo, $file_path);\nfinfo_close($finfo);