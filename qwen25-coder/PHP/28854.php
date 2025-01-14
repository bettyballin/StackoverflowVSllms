// ProductModel.php\nclass ProductModel {\n    public function getProducts($categoryId) {\n        // Fetch products from database based on category ID\n    }\n}\n\n// ProductView.php\nclass ProductView {\n    public function render($products) {\n        // Render the product list as HTML\n    }\n}\n\n// ProductController.php\nclass ProductController {\n    private $model;\n    private $view;\n\n    public function __construct(ProductModel $productModel, ProductView $productView) {\n        $this->model = $productModel;\n        $this->view = $productView;\n    }\n\n    public function displayProducts($categoryId) {\n        $products = $this->model->getProducts($categoryId);\n        return $this->view->render($products);\n    }\n}\n\n// ProductWidget.php\nrequire_once 'ProductModel.php';\nrequire_once 'ProductController.php';\nrequire_once 'ProductView.php';\n\nclass ProductWidget {\n    private $controller;\n\n    public function __construct() {\n        $model = new ProductModel();\n        $view = new ProductView();\n        $this->controller = new ProductController($model, $view);\n    }\n\n    public function display($categoryId) {\n        echo $this->controller->displayProducts($categoryId);\n    }\n}