$redirect = '';\n$regs = '';\n$output = '';\nforeach ($curl_response as $line) {   \n    $line = trim($line); // Remove surrounding whitespace including \r\n    if ($line !== '') {   // Line is not a linebreak, so we're still processing a header block\n        if (preg_match("(HTTP/[0-9]\.[0-9] [0-9]{3} .*)", $line)) {   // Line is the status code\n            $output .= "<b style='background: yellow;'>$line</b>";\n        } elseif (preg_match("/^Location: (.*)$/m", $line, $regs)) {   // Line is a location header, so grab the location being redirected to\n            $output .= "<b style='background: purple; color: white;'>$line</b>";\n            $redirect = $regs[1];\n        } else {   // Some other header, record to output\n            $output .= $line;\n        }\n    } else {   // We've reached a line break, so we're getting to a new block of redirects\n        $output .= "\nreached line break\n";\n        if ($redirect !== '') {   // If we recorded a redirect above, append it to output\n            $output .= "\n\nRedirecting to $redirect\n\n";\n            $redirect = '';\n        }\n    }   \n}\necho $output;