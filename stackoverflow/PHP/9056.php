<?php\n$count = 0;\nwhile($array = mysql_fetch_array($sql)) {\n  $id = 'hidden' . $count++;\n  $data = $array['some_data'];\n  $hidden = $array['hidden_thing'];\n  $other_data = $array['other_data'];\n  echo <<<END\n<tr>\n  <td>$data <a href="#" onclick="toggle('$id');>Toggle</a>\n    <div id="$id">$hidden_thing</div>\n  </td>\n  <td>$other_data</td>\n</tr>\n\nEND;\n}