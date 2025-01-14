#include <stdio.h>
#include <libpq-fe.h>

EXEC SQL BEGIN DECLARE SECTION;
    int a[10] = {9,8,7,6,5,4,3,2,1,0};
    char text[25] = "klmnopqrst";
EXEC SQL END DECLARE SECTION;

int main(void)
{
    EXEC SQL CONNECT TO REGRESSDB1;
    EXEC SQL SET AUTOCOMMIT = ON;
    EXEC SQL BEGIN WORK;
    EXEC SQL CREATE TABLE test (f float, i int, a int[10], text char(10));
    EXEC SQL INSERT INTO test(f,i,a,text) VALUES(404.90,3,'{0,1,2,3,4,5,6,7,8,9}','abcdefghij');
    EXEC SQL INSERT INTO test(f,i,a,text) VALUES(140787.0,2,:a,:text);
    EXEC SQL COMMIT;
    EXEC SQL DISCONNECT;
    return 0;
}