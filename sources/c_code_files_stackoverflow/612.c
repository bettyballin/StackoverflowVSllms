#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node * next;
} Node;

int main() {
    // Example usage:
    Node* head = NULL;
    head = (Node*) malloc(sizeof(Node));
    head->data = 10;
    head->next = NULL;

    printf("Data: %d\n", head->data);

    free(head);

    return 0;
}