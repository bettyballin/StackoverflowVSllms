pp
#include <vector>
#include <string>
#include <stdexcept>

class Validation
{
    std::vector<std::string> *errors;
    void AddError(const std::string &error)
    {
       if (errors == NULL) errors = new std::vector<std::string>();
       errors->push_back(error);
    }

public:
    Validation() : errors(NULL) {}
    ~Validation() { delete errors; }

    const Validation &operator=(const Validation &rhs)
    {
        if (errors == NULL && rhs.errors == NULL) return *this;
        if (rhs.errors == NULL)
        {
            delete errors;
            errors = NULL;
            return *this;
        }
        std::vector<std::string> *temp = new std::vector<std::string>(*rhs.errors);
        std::swap(temp, errors);
        delete temp;
        return *this;
    }

    void Check()
    { 
         if (errors && !errors->empty())
             throw std::exception();
    }

    template <typename T>
    Validation &IsNotNull(T *value)
    {
        if (value == NULL) AddError("Cannot be null!");
        return *this;
    }

    template <typename T, typename S>
    Validation &IsLessThan(T valueToCheck, S maxValue)
    {
        if (valueToCheck >= maxValue) AddError("Value is too big!");
        return *this;
    }

    // etc..
};

class Validate
{
public:
    static Validation Begin() { return Validation(); }
};