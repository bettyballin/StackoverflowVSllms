$text = "<tr>\n        <td id=\"descriptionArea\">\n            Customer request to remove \"Intro - 01/13/09\" video clip.\n            <br/>\n        </td>\n    </tr>";\n\n$pattern = '/descriptionArea&quot;&gt;\s*(.*?)\s*&lt;\/td&gt;/s';\npreg_match($pattern, $text, $matches);\n\nif (isset($matches[1])) {\n    echo $matches[1];\n} else {\n    echo "No match found.";\n}