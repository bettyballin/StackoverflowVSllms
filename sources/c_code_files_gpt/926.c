#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdarg.h>

// Assuming the following PHP-specific structures and functions are defined elsewhere
typedef struct _zval_struct zval;
typedef struct _zend_array zend_array;
typedef struct _sapi_module_struct sapi_module;

extern sapi_module sapi_module;
extern zend_array EG(symbol_table);
extern char *PG(error_log);

#define TSRMLS_DC
#define PHPAPI
#define SUCCESS 0
#define IS_STRING 0
#define Z_ARRVAL_P(p) ((zend_array *)(p))
#define Z_TYPE_PP(p) ((p)->type)
#define Z_STRVAL_PP(p) ((p)->value.str.val)
#define HAVE_SYSLOG_H
#define LOG_NOTICE 0
#define VCWD_FOPEN fopen
#define PHP_EOL "\n"

void php_syslog(int level, const char *format, ...) {
    va_list args;
    va_start(args, format);
    vfprintf(stderr, format, args);
    va_end(args);
}

void php_localtime_r(time_t *timep, struct tm *tm) {
    localtime_r(timep, tm);
}

void php_log_err(char *log_message TSRMLS_DC) {
    FILE *log_file;
    char error_time_str[128];
    struct tm tmbuf;
    time_t error_time;
    char *request_uri = NULL;
    zval *server_vars;
    zval **uri_var;

    // Fetch the $_SERVER variable
    if (zend_hash_find(&EG(symbol_table), "_SERVER", sizeof("_SERVER"), (void **)&server_vars) == SUCCESS) {
        if (zend_hash_find(Z_ARRVAL_P(server_vars), "REQUEST_URI", sizeof("REQUEST_URI"), (void **)&uri_var) == SUCCESS) {
            if (Z_TYPE_PP(uri_var) == IS_STRING) {
                request_uri = Z_STRVAL_PP(uri_var);
            }
        }
    }

    /* Try to use the specified logging location. */
    if (PG(error_log) != NULL) {
#ifdef HAVE_SYSLOG_H
        if (!strcmp(PG(error_log), "syslog")) {
            if (request_uri) {
                php_syslog(LOG_NOTICE, "[%s] %.500s", request_uri, log_message);
            } else {
                php_syslog(LOG_NOTICE, "%.500s", log_message);
            }
            return;
        }
#endif
        log_file = VCWD_FOPEN(PG(error_log), "ab");
        if (log_file != NULL) {
            time(&error_time);
            strftime(error_time_str, sizeof(error_time_str), "%d-%b-%Y %H:%M:%S", php_localtime_r(&error_time, &tmbuf));
            fprintf(log_file, "[%s] ", error_time_str);
            if (request_uri) {
                fprintf(log_file, "[%s] ", request_uri);
            }
            fprintf(log_file, "%s", log_message);
            fprintf(log_file, "%s", PHP_EOL);
            fclose(log_file);
            return;
        }
    }

    /* Otherwise fall back to the default logging location, if we have one */
    if (sapi_module.log_message) {
        sapi_module.log_message(log_message);
    }
}

int main() {
    php_log_err("Test error message");
    return 0;
}