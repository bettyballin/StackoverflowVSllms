// require our common files\nrequire("modules/module.php");\nrequire("registry/objects/datetime.class.php");\nrequire("registry/objects/page.class.php");\n\n// load in all the objects\n$datetime = new dateandtime();\n$page = new page();\n$module = new module();\n\n// Check if $module is an instance of the module class\nif (!$module instanceof module) {\n    die("Error: \$module is not an instance of the module class.");\n}\n\n// Process template\nrequire("template.class.php");\n$template = new template($php_path . "controllers/themes/adm/" . $page . ".html");\n\n// Place in both commonly used language and page specific language\n$template->language($php_path . "controllers/language/en/adm/common.php");\n$template->language($php_path . "controllers/language/en/adm/" . $page . ".php");\n\n// Tell the page's module to load in data it needs\nif (method_exists($module, 'process_data')) {\n    $module->process_data("module_" . $page);\n} else {\n    die("Error: method process_data does not exist in the module class.");\n}\n\n// Output the final result\n$template->output();