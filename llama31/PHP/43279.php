// page1.php\nsession_start();\n$_SESSION['form_data'] = $_POST;\n\n// page2.php\nsession_start();\n$form_data = $_SESSION['form_data'];\n// use $form_data to insert into MySQL table