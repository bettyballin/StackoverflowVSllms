<?php\nwhile ($array = mysql_fetch_array($sql)) {\n    $uniqueId = uniqid('hidden_');\n?>\n<tr>\n    <td>\n        <?php echo $array['some_data']; ?>\n        <a href="#" onclick="toggle('<?php echo $uniqueId; ?>'); return false;">Toggle</a>\n        <div id="<?php echo $uniqueId; ?>" style="display: none;">\n            <?php echo $array['hidden_thing']; ?>\n        </div>\n    </td>\n    <td>\n        <?php echo $array['some_other_data']; ?>\n    </td>\n</tr>\n<?php\n}\n?>