$perPage = 10; // number of results per page\n$page = 1; // current page number\n\n$offset = ($page - 1) * $perPage;\n\n$query = "SELECT * FROM news ORDER BY id DESC LIMIT $offset, $perPage";