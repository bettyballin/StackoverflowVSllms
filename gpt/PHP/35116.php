<?php\n// Set a cookie with the name 'gallery_id' and value 'your_gallery_id'\n$gallery_id = 'your_gallery_id_value';\nsetcookie('gallery_id', $gallery_id, time() + 3600, "/", "", false, true); // Cookie expires in 1 hour\n\n// Other processing code...\n?>