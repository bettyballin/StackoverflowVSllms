$filename = '../'.$_POST['file'];\n$properFilename = $_POST['properFilename'].'.mp3';\n\nheader("Content-Disposition: attachment; filename=\"".basename($properFilename)."\";" );\nheader("Content-Transfer-Encoding: binary");\nheader("Content-Length: ".filesize($filename));\nreadfile("$filename");\nexit();