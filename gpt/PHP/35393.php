<?php\nfunction getTabs(&$item) {\n    global $mainframe;\n\n    $item->created = $item->created;\n\n    list($year, $month, $day) = explode("-", $item->created);\n    $tabdate = date('d/m/y', mktime(0, 0, 0, $month, $day, $year));\n\n    require(JModuleHelper::getLayoutPath('mod_sankeslide', '_tab'));\n}\n?>