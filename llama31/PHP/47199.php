<?php\n$table = 'pages';\n$data = [];\n$errors = [];\n\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n  $data = $_POST;\n  $errors = validate_input($data);\n  if (empty($errors)) {\n    if (create($table, $data)) {\n      echo 'Page created successfully!';\n    } else {\n      echo 'Error creating page!';\n    }\n  }\n}\n\nif ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['id'])) {\n  $id = $_GET['id'];\n  $data = read($table, $id);\n}\n?>\n\n<form action="" method="post">\n  <label for="title">Title:</label>\n  <input type="text" id="title" name="title" value="<?php echo $data['title'] ?? ''; ?>">\n  <?php echo $errors['title'] ?? ''; ?>\n  <br>\n  <label for="content">Content:</label>\n  <textarea id="content" name="content"><?php echo $data['content'] ?? ''; ?></textarea>\n  <?php echo $errors['content'] ?? ''; ?>\n  <br>\n  <input type="submit" value="Save">\n</form>