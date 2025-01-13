SELECT p.id, p.name\nFROM products p\nINNER JOIN properties pr1 ON p.id = pr1.product_id AND pr1.property = 'color' AND pr1.value = 'red'\nINNER JOIN properties pr2 ON p.id = pr2.product_id AND pr2.property = 'size' AND pr2.value = 'small';