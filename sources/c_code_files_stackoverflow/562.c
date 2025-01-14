pp
#include <string>

class mul
{
public:
    mul(int p1, int p2)
    {
        param1 = p1;
        param2 = p2;
    }
    operator int ()
    {
        return param1 * param2;
    }

    operator std::string ()
    {
        return std::string(param2, param1 + '0');
    }

private:
    int param1;
    int param2;
};

int main() {
    mul m(2, 3);
    int result = m;
    std::string str = m;

    // Print the results to verify the functionality
    printf("%d\n", result);
    printf("%s\n", str.c_str());

    return 0;
}