function onThisPageFunction($fileNameFromFunction) {\n  $currentPage = basename($_SERVER['PHP_SELF']);\n  if($currentPage == $fileNameFromFunction) {\n    // do stuff\n  }\n}