// Example of a simple ProductController\n\nclass Controller_Product extends Kohana_Controller_Template {\n\n    public function action_index() {\n        $product_model = new Model_Product();\n        $this->template->products = $product_model->find_all();\n    }\n\n    public function action_view() {\n        $id = $this->request->param('id');\n        $product_model = new Model_Product();\n        $this->template->product = $product_model->find($id);\n    }\n}\n\n// Example of a simple ProductModel\n\nclass Model_Product extends ORM {\n\n    protected $_table_name = 'products';\n\n    public function find_all() {\n        return DB::select()->from('products')->execute()->as_array();\n    }\n\n    public function find($id) {\n        return $this->where('id', '=', $id)->find()->as_array();\n    }\n}