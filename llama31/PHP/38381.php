<?php\n$randomNumber = rand(1, 10);\n$defaultAvatar = '/images/noavatar' . $randomNumber . '.gif';\necho get_avatar($comment, $size = '78', $default = $defaultAvatar);\n?>