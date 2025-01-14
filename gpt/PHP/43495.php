require_once 'ProductModel.php';\nrequire_once 'ProductView.php';\nrequire_once 'ProductController.php';\n\nfunction loadProductWidget($params) {\n    $model = new ProductModel();\n    $view = new ProductView();\n    $controller = new ProductController($model, $view);\n    $controller->display($params);\n}\n\n// Example usage\n$params = $_GET; // or any other source of parameters\nloadProductWidget($params);