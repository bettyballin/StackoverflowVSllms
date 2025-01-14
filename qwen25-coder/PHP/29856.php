class Product {\n    public $id;\n    public $name;\n    public $price;\n\n    public function __construct($data) {\n        $this->id = $data['id'];\n        $this->name = $data['name'];\n        $this->price = $data['price'];\n    }\n}\n\n$jsonResponse = '[{"id":1,"name":"Widget","price":25.99}]';\n$productsData = json_decode($jsonResponse, true);\n$products = [];\n\nforeach ($productsData as $productData) {\n    $products[] = new Product($productData);\n}