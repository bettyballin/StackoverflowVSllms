/* {{{ php_log_err\n */\nPHPAPI void php_log_err(char *log_message TSRMLS_DC)\n{\n    FILE *log_file;\n    char error_time_str[128];\n    struct tm tmbuf;\n    time_t error_time;\n    char key[] = "REQUEST_URI";\n    int key_size = sizeof(key);\n    zval **hsv;\n    zval **var;\n\n    /* Try to use the specified logging location. */\n    if (PG(error_log) != NULL) {\n#ifdef HAVE_SYSLOG_H\n        if (!strcmp(PG(error_log), "syslog")) {\n            if (SUCCESS == zend_hash_find(&EG(symbol_table), "_SERVER", sizeof("_SERVER"), (void **) &hsv)) {\n                if (SUCCESS == zend_hash_find(Z_ARRVAL_PP(hsv), key, key_size - 1, (void **) &var)) {\n                    if (Z_STRVAL_PP(var) && Z_STRLEN_PP(var)) {\n                        char log_buf[1024];\n                        snprintf(log_buf, sizeof(log_buf), "%.500s [REQUEST_URI: %s]", log_message, Z_STRVAL_PP(var));\n                        php_syslog(LOG_NOTICE, log_buf);\n                    } else {\n                        php_syslog(LOG_NOTICE, "%.500s", log_message);\n                    }\n                } else {\n                    php_syslog(LOG_NOTICE, "%.500s", log_message);\n                }\n            } else {\n                php_syslog(LOG_NOTICE, "%.500s", log_message);\n            }\n            return;\n        }\n#endif\n        log_file = VCWD_FOPEN(PG(error_log), "ab");\n        if (log_file != NULL) {\n            time(&error_time);\n            strftime(error_time_str, sizeof(error_time_str), "%d-%b-%Y %H:%M:%S", php_localtime_r(&error_time, &tmbuf));\n            fprintf(log_file, "[%s] ", error_time_str);\n            fprintf(log_file, "%s", log_message);\n            fprintf(log_file, "%s", PHP_EOL);\n            fclose(log_file);\n            return;\n        }\n    }\n\n    /* Otherwise fall back to the default logging location, if we have one */\n\n    if (sapi_module.log_message) {\n        sapi_module.log_message(log_message);\n    }\n}\n/* }}} */