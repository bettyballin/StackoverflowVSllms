$queryString = file_get_contents('php://input');\nparse_str($queryString, $queryParams);