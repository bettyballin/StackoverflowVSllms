$thisTime = gmmktime(0, 0, 0);\n\nfor($i=0; $i<=95; $i++)\n{\n    $sel = "";  // Reset $sel at the start of each iteration\n    $perfTimeNumber = ($i+1);\n    $perfTimestamp = $thisTime;\n    $perfTime = date("H:i", $perfTimestamp);\n    if ($perfTime == '19:30') {\n        $sel = "selected";\n    }\n    echo '<option value="'. $perfTimeNumber .'" '. $sel .'>' .$perfTime .'</option>';\n\n    $thisTime = $thisTime+(15*60);\n}