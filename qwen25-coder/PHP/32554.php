// index.php\nrequire_once('MyController.php');\n\n$controller = new MyController();\n$action = isset($_GET['action']) ? $_GET['action'] : '';\n\nswitch ($action) {\n    case 'getData':\n        echo $controller->getData();\n        break;\n    default:\n        echo json_encode(['status' => 'error', 'message' => 'Action not found']);\n}