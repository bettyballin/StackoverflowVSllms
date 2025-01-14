pp
#include <iostream>

class AClass
{
public:
   AClass( int Data1, int Data2, int Data3 );

   int GetData1();

private:
   int Data1;
   int Data2;
   int Data3;
};

AClass::AClass( int Data1, int Data2, int Data3 )
{
   this->Data1 = Data1;
   this->Data2 = Data2;
   this->Data3 = Data3;
}

int AClass::GetData1()
{
   return Data1;
}

int main()
{
   AClass obj(10, 20, 30);
   std::cout << obj.GetData1() << std::endl;
   return 0;
}