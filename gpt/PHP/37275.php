<?php\nsession_start();\n\n$default_path = 'files/';\n$target_path = ($_POST['dir']) ? $_POST['dir'] : $default_path;\n\nif (!file_exists($target_path)) {\n    mkdir($target_path, 0777, true);\n}\n\n$destination = $target_path . basename($_FILES['Filedata']['name']);\n$file_name = rand(1, 9999) . $_FILES['Filedata']['name'];\n\nif (move_uploaded_file($_FILES['Filedata']['tmp_name'], $destination)) {\n    $_SESSION['path'] = 'flashuploader_online/upload/' . $destination;\n}\n?>