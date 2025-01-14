#include <stdio.h>
#include <string.h>

int main() {
    char sql_stmt[100]; // Ensure the buffer is large enough for the string

    strcpy(sql_stmt, "BEGIN :v_seq := get_seq_number(:v_tabname, :v_seqtype); END;");

    printf("%s\n", sql_stmt); // Print the result to verify the operation

    return 0;
}