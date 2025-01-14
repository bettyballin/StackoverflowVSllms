use Drupal\Core\Ajax\AjaxResponse;\nuse Drupal\Core\Ajax\HtmlCommand;\n\nfunction mymodule_menu() {\n  $items['mymodule/ajax-link'] = [\n    'title' => 'AJAX Link',\n    'page callback' => '\Drupal\mymodule\Controller\MyModuleController::ajaxLinkCallback',\n    'access arguments' => ['access content'],\n  ];\n  return $items;\n}\n\nnamespace Drupal\mymodule\Controller;\n\nuse Drupal\Core\Controller\ControllerBase;\n\nclass MyModuleController extends ControllerBase {\n\n  public function ajaxLinkCallback() {\n    $response = new AjaxResponse();\n\n    // Render some markup or load a block.\n    $markup = 'This is the content loaded via AJAX.';\n    if ($block = \Drupal\block\Entity\Block::load('system_main')) {\n      $markup = $this->entityTypeManager()->getViewBuilder('block')->view($block);\n    }\n\n    // Add an HTML command to insert the markup into an existing element.\n    $response->attachCommand(new HtmlCommand('#content-area', $markup));\n\n    return $response;\n  }\n}