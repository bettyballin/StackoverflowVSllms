if (isset($_GET["hash"])) {\n    $this_min = date('Y-m-d-g', time()) . "salt" . $vid_id;\n    $current_hash = substr(md5($this_min), 0, 12);\n    $submitted_hash = mysql_real_escape_string($_GET["hash"]);\n    \n    if ($current_hash == $submitted_hash) {\n        $file_url2 = "directory/" . $vid_file;\n        \n        // Set the appropriate headers for FLV files\n        header('Content-Type: video/x-flv');\n        header("Expires: 0");\n        header('Cache-Control: no-cache, no-store, must-revalidate, max-age=0');\n        header('Pragma: no-cache');\n        \n        readfile($file_url2);\n        exit;\n    } else {\n        $_SESSION["message"] = "Download link expired, refresh the page and try again";\n        $_SESSION["message_type"] = 0;\n        header("Location:" . $_SERVER['HTTP_REFERER']);\n        exit;       \n    }\n}