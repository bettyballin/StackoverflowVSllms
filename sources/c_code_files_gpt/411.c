#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Node {
    void* data;
    struct Node* next;
} Node;

typedef struct {
    Node* head;
    size_t data_size;
} List;

void init_list(List* list, size_t data_size) {
    list->head = NULL;
    list->data_size = data_size;
}

void add_element(List* list, void* element) {
    Node* new_node = (Node*)malloc(sizeof(Node));
    new_node->data = malloc(list->data_size);
    memcpy(new_node->data, element, list->data_size);
    new_node->next = list->head;
    list->head = new_node;
}

void print_list(List* list, void (*print_func)(void*)) {
    Node* current = list->head;
    while (current != NULL) {
        print_func(current->data);
        current = current->next;
    }
    printf("\n"); // Corrected this line
}

void free_list(List* list) {
    Node* current = list->head;
    Node* next;
    while (current != NULL) {
        next = current->next;
        free(current->data);
        free(current);
        current = next;
    }
    list->head = NULL;
}

// Example print function for integers
void print_int(void* data) {
    printf("%d ", *(int*)data);
}

// Example usage
int main() {
    List list;
    init_list(&list, sizeof(int));

    int a = 1, b = 2, c = 3;
    add_element(&list, &a);
    add_element(&list, &b);
    add_element(&list, &c);

    print_list(&list, print_int);
    free_list(&list);

    return 0;
}