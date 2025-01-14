#include <stdio.h>
#include <stdlib.h>

// Define the structure for a linked list node
typedef struct Node {
    int data;
    struct Node* next;
} Node;

// Function to delete the first node in the linked list
void deleteFirstNode(Node** head) {
    if (*head == NULL) {
        printf("List is empty\n");
        return;
    }

    Node* temp = *head;
    *head = (*head)->next;
    free(temp);
}

int main() {
    // Create a sample linked list: 1 -> 2 -> 3
    Node* head = (Node*)malloc(sizeof(Node));
    head->data = 1;
    head->next = (Node*)malloc(sizeof(Node));
    head->next->data = 2;
    head->next->next = (Node*)malloc(sizeof(Node));
    head->next->next->data = 3;
    head->next->next->next = NULL;

    printf("Original Linked List: 1 -> 2 -> 3\n");

    // Delete the first node
    deleteFirstNode(&head);

    printf("Linked List after deleting first node: ");
    while (head != NULL) {
        printf("%d -> ", head->data);
        head = head->next;
    }
    printf("NULL\n");

    return 0;
}