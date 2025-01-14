// Define the structure for a list node
typedef struct BarListNode {
    int data;
    struct BarListNode* next;
} BarListNode;

// Define the BarList type as a pointer to BarListNode
typedef BarListNode* BarList;

// Function to push a new element to the front of the list
void barPush(BarList* list, int* data) {
    BarListNode* newNode = malloc(sizeof(BarListNode));
    if (!newNode) {
        // Handle memory allocation error
        printf("Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
    newNode->data = *data;
    newNode->next = *list;
    *list = newNode;
}

int main() {
    BarList l;
    l = NULL;
    
    int b1 = 10; // Example data for b1
    int b2 = 20; // Example data for b2
    
    barPush(&l, &b1);
    barPush(&l, &b2);
    
    // Optional: Print the list to verify the push operations
    while (l) {
        printf("%d ", l->data);
        l = l->next;
    }
    printf("\n");
    
    return 0;
}