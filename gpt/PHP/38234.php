<?php\nerror_reporting(E_ALL|E_STRICT);\n\n$uploaddir = "/var/www/ig/images/";\n$uploadfile = $uploaddir . basename($_FILES['fileName']['name']);\n\nif (move_uploaded_file($_FILES['fileName']['tmp_name'], $uploadfile)) {\n    echo "Success.\n";\n} else {\n    echo "Failure.\n";\n}\n\necho 'Here is some more debugging info:';\nprint_r($_FILES);\n?>