use Symfony\Component\HttpFoundation\Response;\n\npublic function myAction()\n{\n    $response = new Response();\n    $response->addJsFile('js/myjavascriptfile.js');\n    return $response;\n}