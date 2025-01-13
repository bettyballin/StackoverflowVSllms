<?php\nnamespace Vendor\Module\Plugin;\n\nuse Magento\Catalog\Block\Product\View;\n\nclass ProductViewPlugin\n{\n    public function afterGetProductDetailsHtml(View $subject, $result)\n    {\n        $product = $subject->getProduct();\n        $createdAt = $product->getCreatedAt();\n        $updatedAt = $product->getUpdatedAt();\n\n        $customHtml = '<p>Created At: ' . date('Y-m-d H:i:s', strtotime($createdAt)) . '</p>';\n        $customHtml .= '<p>Last Updated At: ' . date('Y-m-d H:i:s', strtotime($updatedAt)) . '</p>';\n\n        return $result . $customHtml;\n    }\n}