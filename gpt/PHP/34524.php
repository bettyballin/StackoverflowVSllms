<?php\n// Incorrect: Output before header function\necho "This will cause an issue";\nheader('Location: /new-page.php');