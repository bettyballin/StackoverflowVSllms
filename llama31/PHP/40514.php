$s .= str_replace(\n    array("[[title]]", "[[link]]", "[[description]]", "[[date]]"),\n    array(htmlspecialchars($row["title"], ENT_QUOTES, 'UTF-8'), $url, $description, $date),\n    $item_template\n);