// require our common files\nrequire("modules/module.php"); // Ensure this file defines module class\nrequire("registry/objects/datetime.class.php");\nrequire("registry/objects/page.class.php");\n\n// load in all the objects\n$datetime = new dateandtime;\n$page = new page;\n$module = new module;\n\n// Check if object is correctly instantiated\nif (!$module instanceof module) {\n    die('Failed to instantiate module class');\n}\n\n// ... rest of your code ...\n\n$template = new template($php_path . "controllers/themes/adm/" . $page . ".html");\n\n// Place in both commonly used language and page specific language\n$template->language($php_path . "controllers/language/en/adm/common.php");\n$template->language($php_path . "controllers/language/en/adm/" . $page . ".php");\n\n// Debug output to see if module is still an object\nvar_dump($module);\n\n// Tell the page's module to load in data it needs\n$module->process_data("module_" . $page); // Ensure this file exists and defines read_data()\n\n// Output the final result\n$template->output();