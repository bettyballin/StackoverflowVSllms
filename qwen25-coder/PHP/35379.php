// application/controllers/ProductController.php\n\nclass ProductController extends CI_Controller {\n\n    public function index() {\n        // Load the ProductService library\n        $this->load->library('productservice');\n\n        // Use ProductService to get the product list\n        $products = $this->productservice->getProductList();\n\n        // Pass data to the view\n        $data['products'] = $products;\n        $this->load->view('product_list', $data);\n    }\n}