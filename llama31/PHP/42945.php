foreach ($arrFeeds as $i => $values) {\n    echo "<p><a href='{$values['url']}'>{$values['artist']} - {$values['name']}</a></p>";\n}