<?php\n$cookies = 100;\nwhile ($cookies > 0) {\n    $cookies -= 1;\n    echo '<b>Fatty has </b>' . htmlspecialchars($cookies) . ' <b>cookies left.</b><br>';\n}\n?>