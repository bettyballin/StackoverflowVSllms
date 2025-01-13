function file_size($size)\n{\n    $filesizename = array(" Bytes", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB");\n    return $size ? round($size/pow(1024, ($i = floor(log($size, 1024)))), 2) .$filesizename[$i] : '0 Bytes';\n}