#include <stdlib.h>
#include <stdio.h>

// Define the structure for a linked list node
typedef struct node {
    int data;
    struct node* next;
} node;

int main() {
    // Create a sample linked list with a cycle
    node* begin = (node*) malloc(sizeof(node));
    begin->data = 1;
    begin->next = (node*) malloc(sizeof(node));
    begin->next->data = 2;
    begin->next->next = begin; // Create a cycle

    node* tortoise = begin;
    node* hare = begin;

    while(hare->next != NULL && hare->next->next != NULL) {
        hare = hare->next->next;
        tortoise = tortoise->next;

        if(hare == tortoise) {
            printf("There's a cycle\n");
            return 1;
        }
    }

    printf("No cycle found\n");
    return 0;
}