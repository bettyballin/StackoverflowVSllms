ub4 row_count;\n\n   rc = OCIAttrGet ( stmthp, OCI_HTYPE_STMT, &row_count, 0, OCI_ATTR_ROW_COUNT,\n           errhp );