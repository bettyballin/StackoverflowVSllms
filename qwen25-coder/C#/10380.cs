// Storing data in the session\nSession["UserSearchResults"] = searchResultsDataTable;\n\n// Retrieving data from the session\nDataTable retrievedData = (DataTable)Session["UserSearchResults"];