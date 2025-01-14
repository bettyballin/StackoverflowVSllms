#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct ListNode {
    int value;
    struct ListNode * next;
} ListNode;

bool listcontains(ListNode * node, int v) { 
    // does this node contain the value?
    if(node->value == v) return true; 

    // was this the last node?
    if(node->next == NULL) return false;

    // return whether nodes after us contain the value 
    return listcontains(node->next, v);
}

int main() {
    ListNode * head = malloc(sizeof(ListNode));
    head->value = 1;
    head->next = malloc(sizeof(ListNode));
    head->next->value = 2;
    head->next->next = NULL;

    printf("%d\n", listcontains(head, 2));  // prints: 1 (true)
    printf("%d\n", listcontains(head, 3));  // prints: 0 (false)

    return 0;
}