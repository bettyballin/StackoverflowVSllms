<?php\nif(isset($_POST['myArray'])) {\n    $arrayData = json_decode($_POST['myArray'], true);\n\n    // Now you can work with the array in PHP\n    print_r($arrayData);\n}\n?>