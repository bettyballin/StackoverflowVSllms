// src/Controller/CustomController.php\nnamespace Drupal\mymodule\Controller;\n\nuse Drupal\views\Views;\nuse Symfony\Component\HttpFoundation\Response;\n\n/**\n * Class CustomController.\n */\nclass CustomController {\n\n  /**\n   * Returns HTML of a view without the page template.\n   */\n  public function renderView($id) {\n    // Get the view and execute it.\n    $view = Views::getView($id);\n    if ($view) {\n      $view->setDisplay('default')->execute();\n\n      // Return the rendered content of the view.\n      return new Response($view->preview());\n    }\n\n    // If the view wasn't found, return a 404 response.\n    return new Response('View not found.', 404);\n  }\n}