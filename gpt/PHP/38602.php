use Symfony\Component\HttpFoundation\Response;\n\nclass HealthController\n{\n    public function index()\n    {\n        return new Response(\n            '<html><body>Welcome to the Clinical Healthcare Application!</body></html>'\n        );\n    }\n}