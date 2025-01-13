// MyController.php\nuse Symfony\Component\HttpFoundation\Response;\n\npublic function indexAction()\n{\n    $myVariable = 'Hello, World!';\n    $response = $this->render('dynamic.js.twig', ['my_variable' => $myVariable]);\n    $response->headers->set('Content-Type', 'application/javascript');\n    return $response;\n}