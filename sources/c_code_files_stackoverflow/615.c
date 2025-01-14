pp
#include <mutex>

class ScopedLock {
public:
    ScopedLock(std::mutex& mutex) : mutex_(mutex) {
        mutex_.lock();
    }
    ~ScopedLock() {
        mutex_.unlock();
    }

private:
    std::mutex& mutex_;
};

class Foo {
public:
    void A() {
        ScopedLock lock(mutex_);
        aImp();
    }
    void B() {
        ScopedLock lock(mutex_);
        bImp();
    }

protected:
    virtual void aImp() = 0;
    virtual void bImp() = 0;

private:
    std::mutex mutex_;
};

class FooMiddle : public Foo { // changed to public inheritance
public:
    using Foo::aImp;
    using Foo::bImp;
};

class Bar : public FooMiddle {
public:
    virtual void aImp() override { // corrected function name and added override
        bImp();
        B(); // Now accessible
    }
};