// index.php\nrequire('libs/Smarty.class.php');\n$smarty = new Smarty;\n\n$smarty->caching = Smarty::CACHING_LIFETIME_CURRENT;\n$smarty->cache_lifetime = 120;\n\n$page_center = isset($_GET['module']) ? $_GET['module'] . '.tpl' : 'default.tpl';\n$smarty->assign('page_center', $page_center);\n\n$cacheId = md5($_GET['module']);\n$smarty->display('index.tpl', $cacheId);