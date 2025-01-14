#include <oci.h>
#include <stdio.h>

// Function to describe the table and check for default values
void check_column_defaults(OCIEnv *env, OCIError *err, OCISvcCtx *svc, const char *table_name) {
    OCIStmt *stmt = NULL;
    OCIDescribe *describe = NULL;
    OCIParam *param = NULL;
    OCIParam *col_param = NULL;
    text *default_value;
    ub4 default_len;
    ub4 col_count;
    ub4 i;
    
    // Allocate statement handle
    OCIHandleAlloc(env, (void **)&stmt, OCI_HTYPE_STMT, 0, NULL);
    
    // Prepare the describe handle
    OCIHandleAlloc(env, (void **)&describe, OCI_HTYPE_DESCRIBE, 0, NULL);
    
    // Describe the table
    OCIDescribeAny(svc, err, (text *)table_name, (ub4)strlen(table_name), OCI_OTYPE_NAME, OCI_DEFAULT, OCI_PTYPE_TABLE, describe);
    
    // Get the parameter handle for the table
    OCIAttrGet(describe, OCI_HTYPE_DESCRIBE, &param, 0, OCI_ATTR_PARAM, err);
    
    // Get the number of columns
    OCIAttrGet(param, OCI_DTYPE_PARAM, &col_count, 0, OCI_ATTR_NUM_COLS, err);
    
    for (i = 1; i <= col_count; ++i) {
        // Get the parameter handle for each column
        OCIParamGet(param, OCI_DTYPE_PARAM, err, (void **)&col_param, i);
        
        // Get the default value if it exists
        if (OCIAttrGet(col_param, OCI_DTYPE_PARAM, &default_value, &default_len, OCI_ATTR_COL_DEFAULT, err) == OCI_SUCCESS) {
            printf("Column %d has default value: %.*s\n", i, default_len, default_value);
        } else {
            printf("Column %d has no default value.\n", i);
        }
    }
    
    // Cleanup
    OCIHandleFree(stmt, OCI_HTYPE_STMT);
    OCIHandleFree(describe, OCI_HTYPE_DESCRIBE);
}

int main() {
    OCIEnv *env = NULL;
    OCIError *err = NULL;
    OCISvcCtx *svc = NULL;
    
    // Initialize OCI environment
    OCIEnvCreate(&env, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL);
    
    // Allocate error handle
    OCIHandleAlloc(env, (void **)&err, OCI_HTYPE_ERROR, 0, NULL);
    
    // Connect to the database - replace with your actual connection details
    OCILogon(env, err, &svc, (text *)"username", strlen("username"), (text *)"password", strlen("password"), (text *)"dbname", strlen("dbname"));
    
    // Check column defaults for a specific table
    check_column_defaults(env, err, svc, "your_table_name");
    
    // Disconnect and cleanup
    OCILogoff(svc, err);
    OCIHandleFree(err, OCI_HTYPE_ERROR);
    OCIHandleFree(env, OCI_HTYPE_ENV);
    
    return 0;
}