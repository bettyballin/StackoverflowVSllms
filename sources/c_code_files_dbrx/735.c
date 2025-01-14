#include <stdio.h>

typedef void (*func_t)(struct s _this);
struct s;

int main(void){
    func_t f = (func_t)f; // Suppress warning by using a dummy cast
}