public function getTotal($tax)\n{\n    $total = 0.00;\n\n    // This is a closure that uses the $tax and $total variables from the parent scope\n    $callback = function ($quantity, $product) use ($tax, &$total)\n    {\n        $pricePerItem = constant(__CLASS__ . "::PRICE_" . strtoupper($product));\n        $total += ($pricePerItem * $quantity) * ($tax + 1.0);\n    };\n\n    // array_walk will apply the $callback function to each element in $this->products\n    array_walk($this->products, $callback);\n    return round($total, 2);\n}