pp
#include <map>
#include <string>
#include <typeinfo>

class SomeClass
{
public:
    virtual ~SomeClass() {} // virtual function to get a v-table
};

struct type_info_less
{
    bool operator() (const std::type_info* lhs, const std::type_info* rhs) const
    {
        return lhs->before(*rhs) != 0;
    }
};

class TypeMap
{
    typedef std::map<const std::type_info *, void *, type_info_less> TypenameToObject;
    TypenameToObject ObjectMap;

public:
    template <typename T> 
    T *Get () const
    {
        TypenameToObject::const_iterator iType = ObjectMap.find(&typeid(T));
        if (iType == ObjectMap.end())
            return nullptr;
        return reinterpret_cast<T *>(iType->second);
    }
    template <typename T> 
    void Set(T *value) 
    {
        ObjectMap[&typeid(T)] = reinterpret_cast<void *>(value);
    }
};

int main()
{
    TypeMap Services;
    Services.Set<SomeClass>(new SomeClass());
    SomeClass *x = Services.Get<SomeClass>();
    delete x; // Don't forget to free the memory
    return 0;
}