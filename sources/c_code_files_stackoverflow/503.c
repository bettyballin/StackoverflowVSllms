pp
#include <boost/function_types/function_arity.hpp>
#include <boost/function_types/is_member_pointer.hpp>
#include <boost/type_traits/enable_if.hpp>

template<typename T, class Enable = void> class Wrapper;

/* other specializations... */

// For member functions:
template <class T>
class Wrapper<T, typename boost::enable_if<boost::is_member_pointer<T> >::type>
{ /* boost::function_arity<T>::value has the number of arguments */ };

int main() {
    return 0;
}