#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <curl/curl.h>
#include <libxml/parser.h>
#include <libxml/tree.h>

// Structure to hold webpage content
struct MemoryStruct {
    char *memory;
    size_t size;
};

// Callback for curl to write data
static size_t WriteMemoryCallback(void *contents, size_t size, size_t nmemb, void *userp) {
    size_t realsize = size * nmemb;
    struct MemoryStruct *mem = (struct MemoryStruct *)userp;

    char *ptr = realloc(mem->memory, mem->size + realsize + 1);
    if (ptr == NULL) {
        printf("Not enough memory\n");
        return 0;
    }

    mem->memory = ptr;
    memcpy(&(mem->memory[mem->size]), contents, realsize);
    mem->size += realsize;
    mem->memory[mem->size] = 0;

    return realsize;
}

// Function to initialize CURL and fetch the page content
char *fetchPageContent(const char *url) {
    CURL *curl_handle;
    CURLcode res;

    struct MemoryStruct chunk;
    chunk.memory = malloc(1);
    chunk.size = 0;

    curl_global_init(CURL_GLOBAL_ALL);
    curl_handle = curl_easy_init();
    curl_easy_setopt(curl_handle, CURLOPT_URL, url);
    curl_easy_setopt(curl_handle, CURLOPT_WRITEFUNCTION, WriteMemoryCallback);
    curl_easy_setopt(curl_handle, CURLOPT_WRITEDATA, (void *)&chunk);

    res = curl_easy_perform(curl_handle);
    if (res != CURLE_OK) {
        fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
        free(chunk.memory);
        return NULL;
    }

    curl_easy_cleanup(curl_handle);
    curl_global_cleanup(); // Added this line to clean up curl
    return chunk.memory;
}

// Function to create XML sitemap
void createSitemap(const char *filename, char **urls, int url_count) {
    xmlDocPtr doc = NULL;
    xmlNodePtr root_node = NULL;
    xmlNodePtr url_node = NULL;

    doc = xmlNewDoc(BAD_CAST "1.0");
    root_node = xmlNewNode(NULL, BAD_CAST "urlset");
    xmlNsPtr ns = xmlNewNs(root_node, BAD_CAST "http://www.sitemaps.org/schemas/sitemap/0.9", NULL);
    xmlSetNs(root_node, ns);
    xmlDocSetRootElement(doc, root_node);

    for (int i = 0; i < url_count; i++) {
        url_node = xmlNewChild(root_node, NULL, BAD_CAST "url", NULL);
        xmlNewChild(url_node, NULL, BAD_CAST "loc", BAD_CAST urls[i]);
    }

    xmlSaveFormatFileEnc(filename, doc, "UTF-8", 1);
    xmlFreeDoc(doc);
    xmlCleanupParser();
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <URL>\n", argv[0]);
        return 1;
    }

    const char *url = argv[1];
    char *content = fetchPageContent(url);

    if (content == NULL) {
        fprintf(stderr, "Failed to fetch content from %s\n", url);
        return 1;
    }

    // Here you would parse the content to extract URLs and avoid duplicates.
    // For simplicity, we will use a static list of URLs.

    char *urls[] = {
        "http://example.com/",
        "http://example.com/about/",
        "http://example.com/contact/"
    };
    int url_count = sizeof(urls) / sizeof(urls[0]);

    createSitemap("sitemap.xml", urls, url_count);

    free(content);
    return 0;
}