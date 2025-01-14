//--- Definition of find()
template <typename DataType>
DataType& BST<DataType>::find(const int id ) const
{
   typename BST<DataType>::BinNodePointer locptr = myRoot;

   typename BST<DataType>::BinNodePointer parent =0;

   bool found = false;
   while (!found && locptr != 0)
   {
      if (locptr->data > id)       // descend left
        locptr = locptr->left;
      else if (locptr->data < id)  // descend right
        locptr = locptr->right;
      else                           // item found
        found = true;
   }
   return found ? locptr->data : null;
}