echo $row['active'] == 1 \n    ? '<a href="prof?id=' . htmlspecialchars($id) . '">' . htmlspecialchars($row['username']) . '</a>' \n    : htmlspecialchars($row['username']);