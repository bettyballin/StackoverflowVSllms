#include <iostream>

class Visitor
{
public: 
   template <typename T>
   void operator()( T data ) {
      std::cout << "generic template" << std::endl;
   }
   void operator()( bool data ) {
      std::cout << "regular member function" << std::endl;
   }
};

template <> 
void Visitor::operator()( int data ) {
   std::cout << "specialization" << std::endl;
}

int main()
{
   Visitor v;
   v( 5 ); 
   v( true ); 
   v.operator()<bool>( true ); 
   return 0;
}