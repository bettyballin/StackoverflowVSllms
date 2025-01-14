// combined.c

static int staticVar = 10;  // Static variable with internal linkage
int globalVar = 20;         // Global variable with external linkage

void func() {
    static int localStaticVar = 30;  // Static variable with block scope
    globalVar++;
}

extern int globalVar;

void anotherFunc() {
    globalVar++;
}

int main() {
    func();
    anotherFunc();
    printf("Value of globalVar: %d\n", globalVar);
    return 0;
}