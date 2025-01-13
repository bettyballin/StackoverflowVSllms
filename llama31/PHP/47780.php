function buildMenu($items, $depth = 0) {\n    $menu = '';\n    foreach ($items as $item) {\n        if ($item['depth'] == $depth) {\n            $menu .= '<li>' . $item['title'];\n            $submenu = buildMenu($items, $depth + 1);\n            if (!empty($submenu)) {\n                $menu .= '<ul>' . $submenu . '</ul>';\n            }\n            $menu .= '</li>';\n        }\n    }\n    return $menu;\n}\n\n// assuming $result is your MySQL result array\n$menu = buildMenu($result);\necho '<ul>' . $menu . '</ul>';