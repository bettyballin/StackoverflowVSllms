<?php \n$random_number = rand(1, 10);\n$default_image = '/images/noavatar' . $random_number . '.gif';\necho get_avatar( $comment, $size = '78', $default = $default_image );  \n?>