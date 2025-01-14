function query($query_string) \n{\n    if ($query_string == "") {\n        return 0;\n    }\n\n    if (!$this->connect()) {\n        return 0; \n    };\n\n    if ($this->QueryID) {\n        $this->free_result();\n    }\n\n    if ($this->RecordsPerPage && $this->PageNumber) {\n        $query_string .= " LIMIT " . (($this->PageNumber - 1) * $this->RecordsPerPage) . ", " . $this->RecordsPerPage;\n        $this->RecordsPerPage = 0;\n        $this->PageNumber = 0;\n    } else if ($this->RecordsPerPage) {\n        $query_string .= " LIMIT " . $this->Offset . ", " . $this->RecordsPerPage;\n        $this->Offset = 0;\n        $this->RecordsPerPage = 0;\n    }\n\n    $this->QueryID = @mysql_query($query_string, $this->LinkID);\n    $this->Row   = 0;\n    $this->Errno = mysql_errno();\n    $this->Error = mysql_error();\n    if (!$this->QueryID) {\n        $this->halt("Invalid SQL: " . $query_string);\n    }\n\n    return $this->QueryID;\n}\n\nfunction next_record() \n{\n    if (!$this->QueryID) {\n        $this->halt("next_record called with no query pending.");\n        return 0;\n    }\n\n    $this->Record = @mysql_fetch_array($this->QueryID);\n    $this->Row   += 1;\n    $this->Errno  = mysql_errno();\n    $this->Error  = mysql_error();\n\n    $stat = is_array($this->Record);\n    if (!$stat && $this->AutoFree) {\n        $this->free_result();\n    }\n    return $stat;\n}