if (get_magic_quotes_gpc()) {\n    $process = array(&$_GET, &$_POST, &$_COOKIE, &$_REQUEST);\n    while (list($key, $val) = each($process)) {\n        foreach ($val as $k => $v) {\n            unset($process[$key][$k]);\n            if (is_array($v)) {\n                $process[$key][stripslashes($k)] = $v;\n                $process[] = &$process[$key][stripslashes($k)];\n            } else {\n                $process[$key][stripslashes($k)] = stripslashes($v);\n            }\n        }\n    }\n    unset($process);\n}