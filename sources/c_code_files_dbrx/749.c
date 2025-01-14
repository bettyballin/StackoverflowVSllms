#include <mysql/mysql.h> // Note: The path might vary based on your installation
#include <stdio.h>

int main() {
  MYSQL *conn;

  /* Initialise */
  conn = mysql_init(NULL);

  if (conn == NULL) {
    fprintf(stderr, "Error on init");
    return 1;
  }

  /* Connect to database */
  if (mysql_real_connect(conn, "localhost", "user", "password", "database", 0, NULL, 0 ) == NULL) {
     fprintf(stderr, "%s\n", mysql_error(conn)); // Added newline for clarity
    return 1;
  } else {
      printf("Successful connection\n"); // Added newline for clarity
   }

  /* Clean up */
  mysql_close (conn);
  return 0; // Added return statement for successful execution
}