<?php\n$text = <<<EOD\nHere are some URLs:\nstackoverflow.com/questions/1188129/pregreplace-to-detect-html-php\nHere's the answer: http://www.google.com/search?rls=en&q=42&ie=utf-8&oe=utf-8&hl=en. What was the question?\nA quick look at http://en.wikipedia.org/wiki/URI_scheme#Generic_syntax is helpful.\nThere is no place like 127.0.0.1! Except maybe http://news.bbc.co.uk/1/hi/england/surrey/8168892.stm?\nPorts: 192.168.0.1:8080, https://example.net:1234/.\nBeware of Greeks bringing internationalized top-level domains: xn--hxajbheg2az3al.xn--jxalpdlp.\nAnd remember.Nobody is perfect.\n\n<script>alert('Remember kids: Say no to XSS-attacks! Always HTML escape untrusted input!');</script>\nEOD;\n\n$rexProtocol = '(https?://)?';\n$rexDomain   = '((?:[-a-zA-Z0-9]{1,63}\.)+[-a-zA-Z0-9]{2,63}|(?:[0-9]{1,3}\.){3}[0-9]{1,3})';\n$rexPort     = '(:[0-9]{1,5})?';\n$rexPath     = '(/[!$-/0-9:;=@_\':;!a-zA-Z\x7f-\xff]*?)?';\n$rexQuery    = '(\?[!$-/0-9:;=@_\':;!a-zA-Z\x7f-\xff]+?)?';\n$rexFragment = '(#[!$-/0-9:;=@_\':;!a-zA-Z\x7f-\xff]+?)?';\n\n// Solution 1:\n\nfunction callback($match)\n{\n    // Prepend http:// if no protocol specified\n    $completeUrl = $match[1] ? $match[0] : "http://{$match[0]}";\n\n    return '<a href="' . $completeUrl . '">'\n        . $match[2] . $match[3] . $match[4] . '</a>';\n}\n\nprint "<pre>";\nprint preg_replace_callback("&\\b$rexProtocol$rexDomain$rexPort$rexPath$rexQuery$rexFragment(?=[?.!,;:\"]?(\s|$))&",\n    'callback', htmlspecialchars($text));\nprint "</pre>";