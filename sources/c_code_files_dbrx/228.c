#include <stdio.h>
#include <string.h>
#include <syslog.h>

#define HAVE_SYSLOG_H 1
#define PG(x) x
#define php_syslog syslog
#define LOG_NOTICE LOG_INFO

char error_log[] = "syslog";
char log_mesgae[] = "This is a test log message";
char* _SERVER[] = {"REQUEST_URI", "/test/request/uri"};

int main() {
    #ifdef HAVE_SYSLOG_H
        if (!strcmp(PG(error_log), "syslog")) {
            char request_uri[128];
            sprintf(request_uri, "[Request URI: %s]", _SERVER[1] ? _SERVER[1] : "<not available>");
            php_syslog(LOG_NOTICE, "%.500s %s", log_mesgae, request_uri);
            return 0;
        }
    #endif
    return 1;
}