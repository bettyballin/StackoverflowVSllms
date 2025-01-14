$sql = 'SELECT photos.photo_id, photos.photo_title, photos.photo_filename, '\n       . 'photos.photographer_id, photographers.photographer_name '\n       . 'FROM photos '\n       . 'LEFT JOIN photographers ON photos.photographer_id = photographers.photographer_id '\n       . 'WHERE photo_id = ?';\n\n// initialize prepared statement\n$stmt = $conn->stmt_init(); \nif ($stmt->prepare($sql)) { \n  $stmt->bind_param('i', $_GET['photo_id']); \n  // Adjust bind_result to match the number of columns in SELECT\n  $stmt->bind_result($photo_id, $photo_title, $photo_filename, $photographer_id, $photographer_name); \n  $OK = $stmt->execute(); \n  if ($stmt->fetch()) {\n    echo 'Photo ID: ', htmlspecialchars($photo_id), '<br>';\n    echo 'Photo Title: ', htmlspecialchars($photo_title), '<br>';\n    echo 'Photo Filename: ', htmlspecialchars($photo_filename), '<br>';\n    echo 'Photographer Name: ', htmlspecialchars($photographer_name ?? 'Unknown'), '<br>';\n  } else {\n      echo "No photo found with that ID.";\n  }\n} else {\n    echo 'Error preparing statement:', $conn->error;\n}\n$stmt->close();