use Symfony\Component\Routing\Generator\UrlGeneratorInterface;\n\nclass YourController extends AbstractController\n{\n    public function yourAction(UrlGeneratorInterface $router)\n    {\n        $url = $router->generate('route_name', [\n            'parameter_name' => 'parameter_value',\n        ]);\n\n        // Do something with the URL\n    }\n}