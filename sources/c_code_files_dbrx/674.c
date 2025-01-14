#include <stdbool.h>

#define ALPHABET_SIZE 26

struct Node {
  struct Node* child[ALPHABET_SIZE]; /* Pointing children */
  bool isLeaf;           // To store that a word ends or not at this root
  int actionID;          // The associated action of the current node if it's an end word (isLeaf==true)
};

int main() {
  // Create a node to test the structure
  struct Node node;
  node.isLeaf = false;
  node.actionID = 0;

  // Initialize child pointers to NULL
  for (int i = 0; i < ALPHABET_SIZE; i++) {
    node.child[i] = NULL;
  }

  return 0;
}