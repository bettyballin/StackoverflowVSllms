function remove_img_dimensions($string) {\n    $pattern = '/(?:width|height)\s*=\s*"[0-9]*"/i';\n    $string = preg_replace($pattern, "", $string);\n    return $string;\n}