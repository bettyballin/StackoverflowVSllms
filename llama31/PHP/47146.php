function hasArabicGlyphs($string) {\n    foreach (mb_str_split($string) as $char) {\n        if (IntlChar::getBlockCode($char) === IntlChar::BLOCK_ARABIC) {\n            return true;\n        }\n    }\n    return false;\n}\n\n// Usage:\nwhile ($item = mysql_fetch_array($results)) {\n    if (hasArabicGlyphs($item['item_title'])) {\n        echo "<h3>$item[item_title] <em>(" . $Ar->ar2en($item['item_title']) . ")</em></h3>";\n    } else {\n        echo "<h3>$item[item_title]</h3>";\n    }\n}