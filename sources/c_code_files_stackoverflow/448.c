pp
#include <iostream>

template <class ItemType> class MyContainerBase
{
public:
   MyContainerBase() : _metaData(0) {/* empty */}

   void CopyFrom(const MyContainerBase<ItemType> & copyFrom)
   {
      _metaData = copyFrom._metaData;
      _item     = copyFrom._item;
   }

protected:
  int _metaData;
  ItemType _item;
};

template <class ItemType, class Functor> class MyContainer:
    public MyContainerBase<ItemType>
{
  // whatever you need here -- I made the data above protected
  // just on the assumption you may need to access it here;-)
};

int main() {
    // Example usage:
    MyContainer<int, void> container;
    return 0;
}