prev_month = null\nprev_year = null\nforeach results as r\n    new_month = date('F', r[timestamp]);\n    new_year = date('Y', r[timestamp]);\n    if(prev_month != new_month)\n        //display month\n    /if\n\n    if(prev_year != new_year)\n        //display year\n    /if\n\n    // display other info\n\n    prev_month = new_month\n    prev_year = new_year\n/foreach