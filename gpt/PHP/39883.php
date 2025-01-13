<?php\n    //-- grab info regarding bad request --\n    $root = $_SERVER['DOCUMENT_ROOT'];\n    $page = parse_url($_SERVER['REQUEST_URI']);\n    $page = $page['path'];\n    $referer = $_SERVER['HTTP_REFERER'];\n    $host = $_SERVER['REMOTE_HOST'];\n\n    //-- try to redirect old pages/files ----------------------\n    $page = urlencode($page);\n\n    if (stristr($page, "some_old_file.zip")) {\n        // Example file redirect\n        header("Location: http://www.site.com/the/new/file.zip");\n        exit;\n\n    } elseif (stristr($page, "some_old_page.php")) {\n        // Example webpage redirect\n        header("Location: http://www.site.com/the/new/page.php");\n        exit;\n\n    } elseif (stristr($page, "some_old_image.jpg")) {\n        // Image redirect\n        header("Location: http://www.site.com/path/to/new_image.jpg");\n        exit;\n\n    } else {\n        // Everything else - direct to custom 404 search page\n        header("Location: http://www.site.com/the/custom/404_help.php?page={$page}");\n        exit;\n    }\n?>