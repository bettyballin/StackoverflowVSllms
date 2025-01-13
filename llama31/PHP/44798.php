function dirCount($dir) {\n  $iterator = new DirectoryIterator($dir);\n  $count = 0;\n  foreach ($iterator as $file) {\n    if ($file->isFile() && isImage($file->getFilename())) {\n      $count++;\n    }\n  }\n  return $count;\n}