#define NUMBER_OF_ROWS 1000\n\n// Declare an array to hold the fetched data\nsb4 myNumbers[NUMBER_OF_ROWS];\n\n// Define the array attribute for the statement handle\nOCIDefine *defnp = NULL;\nub2 *indArray = (ub2 *)malloc(sizeof(ub2) * NUMBER_OF_ROWS);\nub2 *elenArray = (ub2 *)malloc(sizeof(ub2) * NUMBER_OF_ROWS);\n\n// Set up define by position for array fetch\nOCIStatus status = OCIDefineByPos(\n    stmthp,       // statement handle\n    &defnp,       // define handle pointer\n    errhp,        // error handle\n    1,            // column index\n    (dvoid *)myNumbers,     // pointer to buffer which will hold fetched data\n    sizeof(sb4),  // size of each element in the array\n    SQLT_INT,     // datatype of the column\n    (dvoid *)indArray,   // pointer to indicator structure (NULLs)\n    elenArray,    // pointer to return lengths of fetched rows\n    NULL,         // pointer to return codes\n    OCI_DEFAULT);  // mode\n\n// Set attribute for prefetch row count if needed\nub4 prefetchRows = NUMBER_OF_ROWS;\nOCIAttrSet(stmthp, OCI_HTYPE_STMT, (dvoid *)&prefetchRows, 0, OCI_ATTR_PREFETCH_ROW_COUNT , errhp);\n\n// Execute the statement\nstatus = OCIStmtExecute(svchp, stmthp, errhp, 2, 0, NULL, NULL, OCI_DEFAULT); // Use 2 as the execute mode to ensure all rows are fetched in one go.\n\n// Fetch the array of rows\nwhile (OCI_SUCCESS == status) {\n    status = OCIStmtFetch2(stmthp, errhp, NUMBER_OF_ROWS, OCI_FETCH_NEXT, 0, OCI_DEFAULT);\n    for (int i = 0; i < NUMBER_OF_ROWS && status != OCI_NO_DATA; ++i) {\n        if (indArray[i] == -1) { // Check for NULL data\n            printf("Row %d is NULL\n", i);\n        } else { \n            printf("Number: %d\n", myNumbers[i]);\n        }\n    }\n}\n\n// Clean up\nfree(indArray);\nfree(elenArray);