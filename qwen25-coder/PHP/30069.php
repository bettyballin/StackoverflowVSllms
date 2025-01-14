<?php\nfunction encode_base62($num) {\n    $chars = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';\n    $base = strlen($chars);\n    $str = '';\n    do {\n        $i = $num % $base;\n        $str .= $chars[$i];\n        $num = ($num - $i) / $base;\n    } while ($num > 0);\n\n    return strrev($str);\n}\n\nfunction get_next_key() {\n    global $link;\n    // Assuming there's a table 'url_ids' with one row storing the last ID\n    $q = "SELECT last_id FROM url_ids";\n    $r = mysqli_query($link, $q);\n    $row = mysqli_fetch_assoc($r);\n    \n    if ($row) {\n        $nextId = $row['last_id'] + 1;\n        // Update the table with the new ID\n        $u = "UPDATE url_ids SET last_id = '$nextId'";\n        mysqli_query($link, $u);\n\n        return encode_base62($nextId);\n    } else {\n        throw new Exception("Failed to retrieve last URL id.");\n    }\n}\n\n// Usage\n$unique_key = get_next_key();\n?>