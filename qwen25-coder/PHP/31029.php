<?php\nsession_start();\nsession_unset();\nsession_destroy();\n\n// Redirect to login or home page after logout\nheader("Location: /login.php");\nexit();\n?>