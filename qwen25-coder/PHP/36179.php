<?php\nif (isset($_POST['clickedButton'])) {\n    $buttonClicked = $_POST['clickedButton'];\n    switch ($buttonClicked) {\n        case 'mint':\n            add_product_to_cart(1);\n            break;\n        case 'near-mint':\n            add_product_to_cart(2);\n            break;\n        case 'standard':\n            add_product_to_cart(3);\n            break;\n        default:\n            // Handle unexpected button values if necessary\n            break;\n    }\n}\n?>