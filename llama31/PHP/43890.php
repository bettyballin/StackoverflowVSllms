// page1.php\n<form action="page2.php" method="post">\n    <input type="hidden" name="form_data" value="<?php echo $_POST['form_data']; ?>">\n    <input type="submit">\n</form>\n\n// page2.php\n$form_data = $_POST['form_data'];\n// use $form_data to insert into MySQL table