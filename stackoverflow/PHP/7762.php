class Tacobell {\n    public function order_burrito() {\n         echo "Bladibla.\n";\n    }\n\n    public function order($item) {\n        if (method_exists($this, "order_$item")) {\n            $this->{'order_' . $item}();\n        } else {\n            echo "Go away, we don't serve $item here.\n";\n        }\n    }\n}