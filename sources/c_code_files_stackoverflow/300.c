pp
class IWantToBeFriendsWithMyStruct
{
    template <typename T, typename U>
    friend struct MyStruct;
};

template <typename T, typename U>
struct MyStruct
{
    // example function to demonstrate friendship
    void example(IWantToBeFriendsWithMyStruct& instance)
    {
        // Because MyStruct is a friend of IWantToBeFriendsWithMyStruct,
        // it would have access to its private and protected members.
    }
};

int main()
{
    IWantToBeFriendsWithMyStruct obj;
    MyStruct<int, double> myStruct;
    myStruct.example(obj);
    return 0;
}