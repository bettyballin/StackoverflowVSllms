$result = mysql_query("SELECT * FROM posts WHERE userid = '$user_id' ORDER BY DATE desc LIMIT 5") or die(mysql_error());\n\nwhile ($row = mysql_fetch_array($result)) {\n    $source = $row['source'];\n    // Escape single quotes in the source string for JavaScript\n    $escapedSource = str_replace("'", "\\'", $source);\n\n    $p = $p . '<div id="red-div"><div id="smartass"><div id="image"><img src="thumbs/' . $user_image . '" /></div><div id="playsong"><a href="#" onclick="playsong(\'' . $escapedSource . '\'); return false;"><img src="play.png" width="16" height="16" border="0" /></a>' . $row['artist'] . ' - ' . $row['title'] . '</div></div><div id="post-comment">' . $row['comment'] . '</div><div id="post-date">' . $row['date'] . '</div></div><div id="dotted-line"></div>';\n}\n\n// Output the JavaScript\necho "parent.document.getElementById('posts').innerHTML = '" . $p . "';";