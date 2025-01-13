$pageno = filter_var($_POST['pageno'], FILTER_VALIDATE_INT);\nif ($pageno !== false) {\n  // Retrieve comments for the given page number\n  $comments = retrieve_comments($pageno);\n  echo json_encode(['comments' => $comments]);\n} else {\n  echo json_encode(['error' => 'Invalid page number']);\n}