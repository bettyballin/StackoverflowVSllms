#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

#define MAX_EXPR_SIZE 100
#define MAX_STACK_SIZE 100

typedef struct {
    int items[MAX_STACK_SIZE]; // Changed type from char to int
    int top;
} Stack;

void initStack(Stack* stack) {
    stack->top = -1;
}

int isEmpty(Stack* stack) {
    return stack->top == -1;
}

int isFull(Stack* stack) {
    return stack->top == MAX_STACK_SIZE - 1;
}

void push(Stack* stack, int item) { // Changed type from char to int
    if (!isFull(stack)) {
        stack->items[++stack->top] = item;
    }
}

int pop(Stack* stack) { // Changed return type from char to int
    if (!isEmpty(stack)) {
        return stack->items[stack->top--];
    }
    return 0;
}

int peek(Stack* stack) { // Changed return type from char to int
    if (!isEmpty(stack)) {
        return stack->items[stack->top];
    }
    return 0;
}

int precedence(char op) {
    switch (op) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '&':
        case '|':
            return 0; // lowest precedence for bitwise operators
        default:
            return -1;
    }
}

int isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '&' || ch == '|';
}

void infixToPostfix(char* infix, char* postfix) {
    Stack stack;
    initStack(&stack);
    int i, k;
    for (i = 0, k = 0; infix[i]; ++i) {
        if (isdigit(infix[i])) {
            postfix[k++] = infix[i];
        } else if (infix[i] == '(') {
            push(&stack, infix[i]);
        } else if (infix[i] == ')') {
            while (!isEmpty(&stack) && peek(&stack) != '(') {
                postfix[k++] = (char)pop(&stack); // Cast to char
            }
            if (!isEmpty(&stack) && peek(&stack) != '(') {
                // invalid expression
                return;
            } else {
                pop(&stack);
            }
        } else if (isOperator(infix[i])) {
            while (!isEmpty(&stack) && precedence(infix[i]) <= precedence((char)peek(&stack))) { // Cast to char
                postfix[k++] = (char)pop(&stack); // Cast to char
            }
            push(&stack, infix[i]);
        }
    }
    while (!isEmpty(&stack)) {
        postfix[k++] = (char)pop(&stack); // Cast to char
    }
    postfix[k] = '\0';
}

int evaluatePostfix(char* postfix) {
    Stack stack;
    initStack(&stack);
    for (int i = 0; postfix[i]; ++i) {
        if (isdigit(postfix[i])) {
            push(&stack, postfix[i] - '0');
        } else {
            int val1 = pop(&stack);
            int val2 = pop(&stack);
            switch (postfix[i]) {
                case '+': push(&stack, val2 + val1); break;
                case '-': push(&stack, val2 - val1); break;
                case '*': push(&stack, val2 * val1); break;
                case '/': push(&stack, val2 / val1); break;
            }
        }
    }
    return pop(&stack);
}

int main() {
    char infix[MAX_EXPR_SIZE];
    char postfix[MAX_EXPR_SIZE];

    printf("Enter an infix expression: ");
    fgets(infix, MAX_EXPR_SIZE, stdin);

    // Remove newline character from the end if present
    size_t len = strlen(infix);
    if (len > 0 && infix[len - 1] == '\n') { // Fixed newline character
        infix[len - 1] = '\0';
    }

    infixToPostfix(infix, postfix);
    printf("Postfix expression: %s\n", postfix);
    printf("Result: %d\n", evaluatePostfix(postfix));

    return 0;
}