$dumpStr = var_export($var,true);\neval('$somevar = ' . $dumpStr . ';');