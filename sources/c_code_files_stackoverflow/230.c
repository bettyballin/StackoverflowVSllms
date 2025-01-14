#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

// Define a simple linked list structure
typedef struct Node {
    int data;
    struct Node* next;
} Node;

// Define a function to create a new node
Node* createNode(int data) {
    Node* newNode = (Node*) malloc(sizeof(Node));
    if (!newNode) {
        printf("Memory error\n");
        return NULL;
    }
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Define a function to check if there is a circle in the linked list
bool hasCircle(Node* head) {
    Node* slow = head;
    Node* fast = head;
    while (fast != NULL && fast->next != NULL) {
        slow = slow->next;
        fast = fast->next->next;
        if (slow == fast) {
            return true;
        }
    }
    return false;
}

int main() {
    // Create a linked list with a circle
    Node* head = createNode(1);
    head->next = createNode(2);
    head->next->next = createNode(3);
    head->next->next->next = head;  // Create a circle

    printf("%d\n", hasCircle(head));  // Should print 1 (true)

    return 0;
}