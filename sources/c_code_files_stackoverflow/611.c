#include <stdio.h>
#include <stdlib.h>

typedef struct list_item list_item;

struct list_item
{
    list_item *next;
    int data;  // assuming "data for node" is an integer
};

int main()
{
    list_item *head = NULL;
    head = (list_item*) malloc(sizeof(list_item));
    head->next = NULL;
    head->data = 10;  // example data

    printf("Data in the node: %d\n", head->data);

    free(head);
    return 0;
}