pp
class IModule
{
public:
    virtual ~IModule() {} // <= important!
    virtual void doStuff() = 0;
};

// Example implementation of IModule
class Module : public IModule
{
public:
    void doStuff() override
    {
        // Implementation of doStuff
    }
};

int main()
{
    IModule* module = new Module();
    module->doStuff();
    delete module;
    return 0;
}