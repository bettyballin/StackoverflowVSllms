#include <stdio.h>
#include <yaml.h>

void emit_event(yaml_event_t *event) {
    /* Your own custom emitter function */
}

int load_next_document() {
    /* Your own function to load documents... */
    return 0;
}

int main() {
    yaml_parser_t parser;  // Our YAML parser object...
    yaml_token_t token = {}; // Our current token, which can be inspected

    if (!yaml_parser_initialize(&parser)) /* Initialize the parser */
        return -1;

    while (load_next_document()) { /* Get the next document from our source */
        /* This is a very simple example of how you might work with libyaml's API. */
        do { /* While we have tokens on this event stream...*/
            if (!yaml_parser_scan(&parser, &token)) {
                fprintf(stderr, "Error parsing YAML.\n");
                return -1;
            }
            emit_event(&token);                  // Our own custom function to handle events
        } while (token.type != YAML_NO_TOKEN); /* Stop when we run out. */
    }
    yaml_parser_delete(&parser);
    return 0;
}