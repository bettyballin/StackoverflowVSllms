function truncateHtml($text, $maxLength) {\n    $printedLength = 0;\n    $position = 0;\n    $tags = [];\n\n    while ($printedLength < $maxLength && preg_match('/<("[^"]*"|\'[^\']*\'|[^\'">])*>|[^<]+/', $text, $match, PREG_OFFSET_CAPTURE, $position)) {\n        $str = $match[0][0];\n        $position = $match[0][1] + strlen($str);\n\n        if ($str[0] == '<') {\n            if ($str[1] == '/') {\n                array_pop($tags);\n            } else {\n                preg_match('/<\s*([^\s>!\/]+)/', $str, $tag);\n                array_push($tags, $tag[1]);\n            }\n            echo $str;\n        } else {\n            $strLength = strlen(html_entity_decode($str));\n            if ($printedLength + $strLength > $maxLength) {\n                echo substr($str, 0, $maxLength - $printedLength);\n                $printedLength = $maxLength;\n                break;\n            } else {\n                echo $str;\n                $printedLength += $strLength;\n            }\n        }\n    }\n\n    while (!empty($tags)) {\n        echo sprintf('</%s>', array_pop($tags));\n    }\n}\n\n$html = 'Hello, my <strong>name</strong> is <em>Sam</em>. I&acute;m a web developer.';\ntruncateHtml($html, 26);