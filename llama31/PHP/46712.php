<?php\nsession_start();\n\n// Get or Create Array\nif (isset($_SESSION['sessRView'])) {\n    $RView = $_SESSION['sessRView'];\n} else {\n    $RView = array();\n}\n\n// Append currently viewed Product to Array\n$newProduct = array(\n    "ID" => $row_rsPrd['PrdID'],\n    "RefCode" => $row_rsPrd['RefCode'],\n    "Name" => $row_rsPrd['Name']\n);\narray_unshift($RView, $newProduct);\n\n// Check if more than 5 products exist in Array, if so delete.\nif (count($RView) > 5) {\n    array_pop($RView);\n}\n\n// Update Session for next page\n$_SESSION['sessRView'] = $RView;\n\n// Display Array\nforeach ($RView as $product) {\n    echo "<ul>";\n    echo "<li><a href='?PrdID=" . $product["ID"] . "'>" . $product["RefCode"] . "</a> : " . $product["Name"] . "</li>";\n    echo "</ul>";\n}\n?>