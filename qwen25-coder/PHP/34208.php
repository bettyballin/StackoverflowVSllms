function getCombinations($string, $traits, $i, &$results)\n{\n    if ($i >= count($traits))\n        $results[] = trim($string);\n    else {\n        foreach ($traits[$i] as $trait)\n            getCombinations("$string$trait", $traits, $i + 1, $results);\n    }\n}\n\n$results = [];\ngetCombinations('', $cat, 0, $results);\n\n// In your form output:\n<form name=form1 method=post action=''>\n<textarea>\n<?php \necho htmlspecialchars(implode("\n", $results)); // Use implode to join results with newlines\n?>\n</textarea>\n</form>