$page = file_get_contents('http://domain.com/page.html');\n$page = str_replace('href="/', 'href="http://domain.com/', $page);\necho $page;