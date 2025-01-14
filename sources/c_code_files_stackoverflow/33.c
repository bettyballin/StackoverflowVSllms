pp
#include <iterator>
#include <iostream>

template <typename T1, typename T2>
struct concat_iterator
{
public:
   typedef std::forward_iterator_tag iterator_category;
   typedef typename std::iterator_traits<T1>::value_type value_type;
   typedef value_type* pointer; 
   typedef value_type& reference;

   concat_iterator( T1 b1, T1 e1, T2 b2, T2 e2 ) 
      : seq1( b1 ), seq1end( e1 ), seq2( b2 ), seq2end( e2 ) {}
   concat_iterator& operator++() {
      if ( seq1 != seq1end ) ++seq1;
      else ++seq2;
      return *this;
   }
   reference operator*() {
      if ( seq1 != seq1end ) return *seq1;
      else return *seq2;
   }
   pointer operator->() {
      if ( seq1 != seq1end ) return &(*seq1);
      else return &(*seq2);
   }
   bool operator==( const concat_iterator & rhs ) const {
      return seq1==rhs.seq1 && seq1end==rhs.seq1end 
          && seq2==rhs.seq2 && seq2end==rhs.seq2end;
   }
   bool operator!=( const concat_iterator & rhs ) const {
      return !(*this == rhs);
   }
private:
   T1 seq1;
   T1 seq1end;
   T2 seq2;
   T2 seq2end;
};

template <typename T1, typename T2>
concat_iterator<T1,T2> concat_begin( T1 b1, T1 e1, T2 b2, T2 e2 )
{
   return concat_iterator<T1,T2>(b1,e1,b2,e2);
}
template <typename T1, typename T2>
concat_iterator<T1,T2> concat_end( T1 b1, T1 e1, T2 b2, T2 e2 )
{
   return concat_iterator<T1,T2>(e1,e1,e2,e2);
}

int main() {
    int arr1[] = {1, 2, 3};
    int arr2[] = {4, 5, 6};

    auto begin = concat_begin(std::begin(arr1), std::end(arr1), std::begin(arr2), std::end(arr2));
    auto end = concat_end(std::begin(arr1), std::end(arr1), std::begin(arr2), std::end(arr2));

    for (; begin != end; ++begin) {
        std::cout << *begin << " ";
    }
    return 0;
}