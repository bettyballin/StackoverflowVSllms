$PIC_URL = isset($_REQUEST['PIC_URL']) ? $_REQUEST['PIC_URL'] : '';\n\nif (filter_var($PIC_URL, FILTER_VALIDATE_URL)) {\n    $handle = @fopen($PIC_URL, "r");\n    if ($handle) {\n        fclose($handle);\n        $status = 1;\n    } else {\n        $status = 2;\n    }\n} else {\n    // URL is not valid\n    $status = 2;\n}\n\nif ($status == 2) {\n    $PIC_URL = "http://www.tricityhomes.com/assets/images/noimage.gif";\n}