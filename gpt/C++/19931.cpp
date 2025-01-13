#include <curl/curl.h>\n#include <iostream>\n\nint main() {\n    CURL *curl;\n    CURLcode res;\n    FILE *file;\n\n    file = fopen("path/to/your/file.txt", "rb");\n    if(!file) {\n        std::cerr << "Could not open file for reading" << std::endl;\n        return 1;\n    }\n\n    curl_global_init(CURL_GLOBAL_DEFAULT);\n\n    curl = curl_easy_init();\n    if(curl) {\n        // Set the URL that receives the upload\n        curl_easy_setopt(curl, CURLOPT_URL, "ftp://yourserver.com/upload/file.txt");\n        curl_easy_setopt(curl, CURLOPT_USERPWD, "username:password");\n\n        // Enable FTPS\n        curl_easy_setopt(curl, CURLOPT_USE_SSL, CURLUSESSL_ALL);\n\n        // Specify the file to upload\n        curl_easy_setopt(curl, CURLOPT_READDATA, file);\n        curl_easy_setopt(curl, CURLOPT_UPLOAD, 1L);\n\n        // Perform the request, res will get the return code\n        res = curl_easy_perform(curl);\n        \n        // Check for errors\n        if(res != CURLE_OK)\n            std::cerr << "curl_easy_perform() failed: " << curl_easy_strerror(res) << std::endl;\n\n        // Cleanup\n        curl_easy_cleanup(curl);\n    }\n\n    fclose(file);\n    curl_global_cleanup();\n\n    return 0;\n}