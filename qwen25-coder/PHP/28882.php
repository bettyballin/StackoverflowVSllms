<?php\nrequire('Smarty.class.php');\n\n$smarty = new Smarty;\n\n// Configure the location of directories\n$smarty->setTemplateDir('templates/Default/');\n$smarty->setCompileDir('templates_c/');\n$smarty->setCacheDir('cache/');\n$smarty->setConfigDir('configs/');\n\n// Assign base path for assets\n$assetsPath = 'http://example.com/templates/Default/';\n$smarty->assign('base_path', $assetsPath);\n\n// Now display a template\n$smarty->display('index.tpl');\n?>