<?php\nrequire_once "File/Archive.php";\n$tmp = 'output';\n$t1 = 'check.tar';\nFile_Archive::setOption('tmpDirectory','tmp');\n$r = File_Archive::extract(\n    File_Archive::read($t1.'/'),\n    File_Archive::toFiles($tmp)\n);\n?>