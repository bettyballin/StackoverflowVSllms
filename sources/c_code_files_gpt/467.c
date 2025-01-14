#pragma GCC optimize "O2"
#pragma GCC diagnostic error "-Wuninitialized"

int main() {
    int x;
    int y = x; // This should now be treated as an error
    return 0;
}