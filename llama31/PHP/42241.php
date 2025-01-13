$nid = intval($nid); // ensure $nid is an integer\n\n/navQuery = "SELECT n.NavName, npc.cID\nFROM tblNavPC npc\nJOIN tblNav n ON npc.cID = n.NavID\nWHERE npc.PID = :pid";\n\n$pdo = new PDO('mysql:host=your_host;dbname=your_db', 'your_username', 'your_password');\n$stmt = $pdo->prepare($navQuery);\n$stmt->bindParam(':pid', $nid, PDO::PARAM_INT);\n$stmt->execute();\n\n$numNavItems = $stmt->rowCount();\n\nif ($numNavItems > 0) {\n    echo '<tr>\n        <td align="left" valign="top" class="medium"><h1>' . $NavName . '</h1></td>\n    </tr>';\n\n    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n        $childName = $row['NavName'];\n        $childNavID = $row['cID'];\n        echo '<tr>\n            <td align="left" valign="top" class="medium">\n                <a href="cat_ap~pnid~' . $nid . '~nid~' . $childNavID . '~post.htm">' . $childName . '</a>\n            </td>\n        </tr>';\n    }\n}