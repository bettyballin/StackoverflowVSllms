<?php\nif (isset($_POST['id'])) {\n  $id = $_POST['id'];\n  $query = "DELETE FROM tbl_payments WHERE id = '$id'";\n  $result = mysql_query($query) or die(mysql_error());\n  if ($result) {\n    echo "success";\n  } else {\n    echo "Error deleting record: " . mysql_error();\n  }\n  exit;\n}\n?>