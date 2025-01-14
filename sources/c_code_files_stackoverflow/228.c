pp
#include <iostream>

// The class for which calling any method should call PreMethod first.
class DogImplementation
{
public:
   void PreMethod() {
       std::cout << "PreMethod called" << std::endl;
   }
   void Bark() {
       std::cout << "Bark called" << std::endl;
   }
private:
   DogImplementation() {} // constructor private so can only be created via smart-pointer.
   friend class Dog; // can access constructor.
};

// A 'smart-pointer' that wraps a DogImplementation to give you
// more control.
class Dog
{
public:
   DogImplementation* operator -> ()
   {
       _impl.PreMethod();
       return &_impl;
   }
private:
   DogImplementation _impl;
};

// Example usage of the smart pointer. Use -> instead of .
void UseDog()
{
  Dog dog;
  dog->Bark();    // will call DogImplementation::PreMethod, then DogImplementation::Bark
}

int main() {
    UseDog();
    return 0;
}