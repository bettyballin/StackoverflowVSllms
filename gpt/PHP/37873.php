$siteID = $_GET['siteID'];\n\nif (filter_var($siteID, FILTER_VALIDATE_INT) !== false) {\n    $siteID = (int) $siteID;\n    // Now $siteID is a valid integer\n} else {\n    // Handle the error - $siteID is not a valid integer\n}