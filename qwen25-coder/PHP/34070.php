// src/Controller/YourComponentController.php\nnamespace App\Controller;\n\nuse Symfony\Bundle\FrameworkBundle\Controller\AbstractController;\nuse Symfony\Component\HttpFoundation\Response;\n\nclass YourComponentController extends AbstractController\n{\n    public function executeTest(): Response\n    {\n        // Render a template from a subfolder\n        return $this->render('component/_Test.html.twig');\n    }\n}