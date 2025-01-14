#include <stdio.h>
#include <stdlib.h>

// Define the structure for a doubly linked list node
typedef struct Node {
    char data;
    struct Node* next;
    struct Node* back;
} Node;

// Function to add a new node at the end of the list
void add_node(Node** head, char c) {
    Node* new_last_node = (Node*)malloc(sizeof(Node));
    if (*head == NULL) {
        *head = new_last_node;
        new_last_node->next = NULL;
        new_last_node->back = NULL;
        new_last_node->data = c;
    } else {
        Node* old_last_node = *head;
        while (old_last_node->next != NULL) {
            old_last_node = old_last_node->next;
        }
        // Re-assign the double link and exit link
        old_last_node->next = new_last_node;
        new_last_node->back = old_last_node;
        new_last_node->data = c; // Initialize node's data with argument 'c';
        new_last_node->next = NULL;
    }
}

// Function to print the linked list from head to tail
void print_list(Node* head) {
    while (head != NULL) {
        printf("%c ", head->data);
        head = head->next;
    }
    printf("\n");
}

int main() {
    Node* head = NULL;
    
    // Example usage: Adding nodes to the list and printing
    add_node(&head, 'A');
    add_node(&head, 'B');
    add_node(&head, 'C');
    
    print_list(head);
    
    return 0;
}