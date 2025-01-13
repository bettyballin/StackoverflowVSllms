<?php\n/*\n* Smarty plugin\n* ————————————————————-\n* File:     function.recurse_array.php\n* Type:     function\n* Name:     recurse_array\n* Purpose:  prints out elements of an array recursively\n* ————————————————————-\n*/\n\nfunction smarty_function_recurse_array($params, &$smarty)\n{\n\nif (is_array($params['array']) && count($params['array']) > 0) {\n   $markup = '';\n\n   $markup .= '<ul>';\n\n   foreach ($params['array'] as $element) {\n      $markup .= '<li>';\n\n      $markup .= '<h1>' . $element['headline'] . '</h1>';\n      $markup .= '<p>' . $element['body'] . '</p>';\n\n      if (isset($element['children'])) {\n         $markup .= smarty_function_recurse_array(array('array' => $element['children']), $smarty);\n      }\n\n       $markup .= '</li>';\n   }\n\n   $markup.= '</ul>';\n\n   return $markup;\n\n} else {\n   return 'not array';\n}\n}