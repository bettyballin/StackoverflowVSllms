#include <curl/curl.h>\n\nint main() {\n    CURL *curl;\n    CURLcode res;\n    FILE *file;\n\n    /* Initialize libcurl */\n    curl_global_init(CURL_GLOBAL_DEFAULT);\n\n    /* Create a curl handle */\n    curl = curl_easy_init();\n    if(curl) {\n        /* Set the URL and protocol */\n        curl_easy_setopt(curl, CURLOPT_URL, "https://example.com/upload");\n\n        /* Set the file to send */\n        file = fopen("large_file.bin", "rb");\n        curl_easy_setopt(curl, CURLOPT_READFUNCTION, fread);\n        curl_easy_setopt(curl, CURLOPT_READDATA, file);\n\n        /* Set the chunk size */\n        curl_easy_setopt(curl, CURLOPT_CHUNK_SIZE, 1024);\n\n        /* Send the file */\n        res = curl_easy_perform(curl);\n\n        /* Cleanup */\n        fclose(file);\n        curl_easy_cleanup(curl);\n    }\n\n    curl_global_cleanup();\n    return 0;\n}