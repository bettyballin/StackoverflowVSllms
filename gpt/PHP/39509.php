<?php\n$pk = $row['ARTICLE_NO'];\necho '<tr>';\necho '<td><a href="#" onclick="updateByPk(\'Layer2\', \'' . $pk . '\')">' . $row['USERNAME'] . '</a></td>';\necho '<td><a href="#" onclick="updateByPk(\'Layer2\', \'' . $pk . '\')">' . $row['shortDate'] . '</a></td>';\necho '<td><a href="#" onclick="updateByPk(\'Layer2\', \'' . $pk . '\')">' . $row['ARTICLE_NAME'] . '</a></td>';\necho '<td><a href="#" onclick="deleterec(\'Layer2\', \'' . $pk . '\')">Delete</a></td>';\necho '</tr>';\n?>