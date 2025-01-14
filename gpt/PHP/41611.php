<?php\n// Connect to the MySQL database\n$pdo = new PDO('mysql:host=your_host;dbname=your_db', 'your_user', 'your_password');\n\n// Fetch the rows from the database\n$sql = "SELECT * FROM Auctions";\n$stmt = $pdo->query($sql);\n\necho '<table border="1">';\nwhile ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n    $articleDesc = htmlspecialchars($row['ARTICLE_DESC'], ENT_QUOTES, 'UTF-8');\n    echo '<tr onclick="openPopup(\'' . $articleDesc . '\')">';\n    echo '<td>' . htmlspecialchars($row['ARTICLE_NO'], ENT_QUOTES, 'UTF-8') . '</td>';\n    echo '<td>' . $articleDesc . '</td>';\n    echo '</tr>';\n}\necho '</table>';\n?>\n\n<script>\n// JavaScript function to open a new popup window and write HTML content into it\nfunction openPopup(htmlContent) {\n    var popupWindow = window.open("", "_blank", "width=600,height=400");\n    popupWindow.document.write("<html><head><title>Popup</title></head><body>");\n    popupWindow.document.write(htmlContent);\n    popupWindow.document.write("</body></html>");\n    popupWindow.document.close();\n}\n</script>