// index.php\nrequire_once 'vendor/autoload.php';\n\n$loader = new Twig_Loader_Filesystem('templates');\n$twig = new Twig_Environment($loader);\n\n$pageTitle = 'My Page';\n$content = 'Hello, World!';\n\n$template = $twig->load('layout.twig');\necho $template->render(['pageTitle' => $pageTitle, 'content' => $content]);