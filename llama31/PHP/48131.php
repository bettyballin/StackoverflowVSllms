<?php\nsession_start();\n\n$filename = $_SESSION['$serverURL'].'audio/'.$_SESSION['fileName'].'.mp3';\n$properFilename = $_GET['properFilename'].'.mp3';\n\nif(ini_get('zlib.output_compression'))\n  ini_set('zlib.output_compression', 'Off');\n\n$file_extension = strtolower(substr(strrchr($filename,"."),1));\n\nif( $filename == "" ) \n{\n  exit;\n} elseif ( !@get_headers($filename, 1) ) \n{\n  exit;\n};\n\nswitch( $file_extension )\n{\n  case "pdf": $ctype="application/pdf"; break;\n  case "exe": $ctype="application/octet-stream"; break;\n  case "zip": $ctype="application/zip"; break;\n  case "doc": $ctype="application/msword"; break;\n  case "xls": $ctype="application/vnd.ms-excel"; break;\n  case "ppt": $ctype="application/vnd.ms-powerpoint"; break;\n  case "gif": $ctype="image/gif"; break;\n  case "png": $ctype="image/png"; break;\n  case "jpeg":\n  case "jpg": $ctype="image/jpg"; break;\n  default: $ctype="application/force-download";\n}\n\nheader("Pragma: public");\nheader("Expires: 0");\nheader("Cache-Control: must-revalidate, post-check=0, pre-check=0");\nheader("Cache-Control: private",false);\nheader("Content-Type: $ctype");\nheader("Content-Disposition: attachment; filename=\"".basename($properFilename)."\";" );\nheader("Content-Transfer-Encoding: binary");\n\n$remote_file_size = get_headers($filename, 1)['Content-Length'];\nheader("Content-Length: $remote_file_size");\n\nreadfile("$filename");\nexit();\n?>