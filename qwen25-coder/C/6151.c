#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <curl/curl.h> // You need to install libcurl development package\n\ntypedef struct MemoryStruct {\n    char *memory;\n    size_t size;\n} MemoryStruct;\n\n// Function to initialize memory buffer for storing HTML content\nstatic void InitMem(MemoryStruct *chunk) {\n    chunk->memory = malloc(1);  // Will be grown as needed by the realloc above\n    chunk->size = 0;            // No data at this point\n    if(chunk->memory == NULL) {\n        printf("Memory allocation error! Out of Memory?\n");\n        return;\n    }\n}\n\n// Callback function to get the HTML content in memory using libcurl\nstatic size_t WriteMemCallback(void *contents, size_t size, size_t nmemb, void *userp) {\n    size_t realsize = size * nmemb;\n    struct MemoryStruct *mem = (struct MemoryStruct *)userp;\n    char *ptr = realloc(mem->memory, mem->size + realsize + 1);\n    if(ptr == NULL) return 0;  /* out of memory! */\n\n    mem->memory = ptr;\n    memcpy(&(mem->memory[mem->size]), contents, realsize);\n    mem->size += realsize;\n    mem->memory[mem->size] = 0;\n\n    return realsize;\n}\n\n// Function to clean the MemoryStruct\nvoid freeMem(MemoryStruct *res) {\n    free(res->memory);\n    res->size = 0;\n}\n\n// Simple recursive crawler function that fetches pages and stores URLs\nvoid crawl(const char* url, FILE* sitemapFile) {\n    CURL *curl_handle; \n    CURLcode result;\n    MemoryStruct chunk;\n\n    InitMem(&chunk);\n\n    curl_global_init(CURL_GLOBAL_DEFAULT);\n    curl_handle = curl_easy_init();\n    if(curl_handle) {\n        // Set the URL to fetch\n        curl_easy_setopt(curl_handle, CURLOPT_URL, url);\n\n        /* Write to the memory*/\n        curl_easy_setopt(curl_handle, CURLOPT_WRITEFUNCTION , WriteMemCallback);\n        curl_easy_setopt(curl_handle, CURLOPT_WRITEDATA, (void *)&chunk);\n\n        result = curl_easy_perform(curl_handle);\n        if(result == CURLE_OK) {\n            // Here you'd typically parse with an HTML parser to find links\n            printf("%s\n", chunk.memory); // or process data as needed...\n            \n            // For demonstration purposes, just write the URL to the sitemap file:\n            fprintf(sitemapFile, "<url>\n");\n            fprintf(sitemapFile, "  <loc>%s</loc>\n", url);\n            fprintf(sitemapFile, "</url>\n");\n        }\n\n        /* Cleanup */\n        curl_easy_cleanup(curl_handle);\n    }\n    freeMem(&chunk);\n    curl_global_cleanup();\n}\n\nint main(int argc, char *argv[]) {\n    if(argc != 2) {\n        printf("Please specify a URL to crawl.\nUsage example: %s https://example.com\n", argv[0]);\n        return -1;\n    }\n\n    const char* startUrl = argv[1];\n    FILE* sitemapFile = fopen("sitemap.xml", "w");\n    \n    // Start of XML Sitemap\n    fprintf(sitemapFile, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");\n    fprintf(sitemapFile, "<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");\n\n    crawl(startUrl, sitemapFile);\n\n    // End of XML Sitemap\n    fprintf(sitemapFile, "</urlset>");\n\n    fclose(sitemapFile);\n    \n    printf("Finished creating 'sitemap.xml'.\n");\n    return 0;\n}