class ProductView {\n    public function render($products) {\n        foreach ($products as $product) {\n            echo "<div class='product'>{$product['name']}</div>";\n        }\n    }\n}