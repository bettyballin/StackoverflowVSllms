if(!function_exists("odbc_fetch_array"))\n  {\n    function odbc_fetch_array($aResult,$anAssoc=false)\n    {\n        # Out of rows? Pass back false!\n        if(!odbc_fetch_row($aResult)) return false;\n\n        $theRow = array();\n\n          # Build up array\n        $theNumFields = odbc_num_fields($aResult);\n        $theLimit = $theNumFields+1;\n          for($i=1; $i<$theLimit; $i++)\n          {\n            # WARNING: Starts our index at 0, unlike standard ODBC which starts at 1\n              $theRow[odbc_field_name($aResult, $i)] = odbc_result($aResult, $i);\n              if(!$anAssoc) $theRow[$i-1] = $theRow[odbc_field_name($aResult, $i)];\n        }\n        return $theRow;\n    }\n  }\n\n  if(!function_exists("odbc_fetch_assoc"))\n  {\n    function odbc_fetch_assoc($aResult)\n    {   \n        if (DIRECTORY_SEPARATOR == '/') // call local function on MACs\n        {\n            return odbc_fetch_array($aResult,true);\n        }\n        else // call built in function on Windows\n        {\n            return odbc_fetch_array($aResult);\n        }\n    }\n  }