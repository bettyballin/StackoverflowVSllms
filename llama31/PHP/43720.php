// template.html.twig\n<p>Hello, {{ name }}!</p>\n\n// PHP code\n$twig = new Twig_Environment();\n$template = $twig->loadTemplate('template.html.twig');\necho $template->render(array('name' => 'John'));