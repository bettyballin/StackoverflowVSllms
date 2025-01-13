// CategoryService.php\nclass CategoryService {\n    private $db;\n\n    public function __construct($db) {\n        $this->db = $db;\n    }\n\n    public function getCategories() {\n        $categories = $this->db->fetchAll('SELECT * FROM categories');\n        return $categories;\n    }\n}\n\n// CategoryController.php\nclass CategoryController extends Zend_Controller_Action {\n    private $categoryService;\n\n    public function init() {\n        $this->categoryService = new CategoryService($this->getDb());\n    }\n\n    public function indexAction() {\n        $categories = $this->categoryService->getCategories();\n        $this->view->categories = $categories;\n    }\n}\n\n// CategoryViewHelper.php\nclass CategoryViewHelper extends Zend_View_Helper_Abstract {\n    public function categories() {\n        $categories = $this->view->categories;\n        // render the categories HTML\n    }\n}\n\n// In your template\n<?php echo $this->categories(); ?>