int main() {
        int x = 10;
        int y = 0;
        int z = x / y; // Undefined behavior: division by zero
        return 0;
    }