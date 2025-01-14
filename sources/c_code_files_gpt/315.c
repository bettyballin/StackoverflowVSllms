#include <my_global.h>
#include <my_sys.h>
#include <mysql.h>
#include <ctype.h>  // Include for toupper function
#include <string.h> // Include for strcpy function

my_bool my_function_init(UDF_INIT *initid, UDF_ARGS *args, char *message) {
    if (args->arg_count != 1 || args->arg_type[0] != STRING_RESULT) {
        strcpy(message, "Expected one string argument");
        return 1;
    }
    return 0;
}

void my_function_deinit(UDF_INIT *initid) {
    // Cleanup code if needed
}

char* my_function(UDF_INIT *initid, UDF_ARGS *args, char *result, unsigned long *length, char *is_null, char *error) {
    // Example: convert the input string to uppercase
    char *input = args->args[0];
    int i;
    for (i = 0; input[i] != '\0'; i++) {
        result[i] = toupper(input[i]);
    }
    result[i] = '\0';
    *length = i;
    return result;
}