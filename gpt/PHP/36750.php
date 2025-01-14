<?php\n$htaccess_file = '.htaccess';\n$new_rule = "\nRewriteRule ^new-category/(.*)$ category.php?id=$1 [L]";\n\nif (is_writable($htaccess_file)) {\n    if (!$fp = fopen($htaccess_file, 'a')) {\n        echo "Cannot open file ($htaccess_file)";\n        exit;\n    }\n\n    if (fwrite($fp, $new_rule) === FALSE) {\n        echo "Cannot write to file ($htaccess_file)";\n        exit;\n    }\n\n    echo "Success, wrote new rule to file ($htaccess_file)";\n\n    fclose($fp);\n\n} else {\n    echo "The file $htaccess_file is not writable";\n}\n?>