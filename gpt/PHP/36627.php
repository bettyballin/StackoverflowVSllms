$pages = array("grac", "zamknij", "dolaczyc");\n$pagesid = array("showNews", "showThread", "showProfile");\n\n$pageIncluded = false;\n\nforeach ($pagesid as $page) {\n  if (isset($_GET[$page])) {\n    include('sobra/'.$page.'.php');\n    $pageIncluded = true;\n    break;\n  }\n}\n\n// just pages\nif (!$pageIncluded && in_array($_GET['page'], $pages)) {\n  include($_GET['page'].'.php');\n}\n// error\nelse if (!$pageIncluded) {\n  include('error.php');\n}