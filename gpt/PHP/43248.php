// When displaying the output in another TEXTAREA box\n$textarea_content = $_POST['your_textarea_name'];\n$decoded_content = htmlspecialchars_decode($textarea_content, ENT_QUOTES);\necho '<textarea>' . $decoded_content . '</textarea>';