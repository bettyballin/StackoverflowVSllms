foreach ($arr_nav as $key => $value) {\n    $class = '';\n    if ($key == 0) {\n        $class = 'first';\n    } elseif ($key == count($arr_nav) - 1) {\n        $class = 'last';\n    }\n    echo '<li id="' . $value["id"] . '" class="' . $class . '"><a href="' . $v_url_root . $value["url"] . '" title="' . $value["name"] . '">' . $value["name"] . '</a></li>' . "\r\n";\n}