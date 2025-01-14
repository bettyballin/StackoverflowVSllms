function deleteOldFiles($dir, $days) {\n  // Ensure the directory string ends with a slash or backslash\n  if (substr($dir, -1) !== '/' && substr($dir, -1) !== '\\') {\n    $dir .= DIRECTORY_SEPARATOR;\n  }\n\n  $mydir = opendir($dir);\n  while(($file = readdir($mydir)) !== false) {\n    // Skip current and parent directory entries\n    if($file === "." || $file === "..") continue;\n\n    $filePath = $dir . $file; // Correctly concatenate paths\n    if(filemtime($filePath) <= time() - ($days * 86400)) {\n      echo filemtime($filePath); // Output the last modification time for debugging\n\n      // Uncomment the following line to delete files after verifying paths are correct\n      // unlink($filePath) or die("Failed to delete $filePath\n");\n    }\n  }\n  closedir($mydir);\n}