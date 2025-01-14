#include <iostream>
#include <sstream>
#include <boost/noncopyable.hpp>
#include <chrono>

namespace scope_timer {
    class time_collector : boost::noncopyable {
        double total;
        std::chrono::high_resolution_clock::time_point start;
        size_t times;
        const char* name;

        bool in_use;

    public:
        time_collector(const char* n)
            : times(0)
            , name(n)
            , total(0)
            , start()
            , in_use(false)
        {
        }

        ~time_collector()
        {
            std::ostringstream msg;
            msg << "scope_timer> " <<  name << " called: ";

            double seconds = total;
            double average = seconds / times;

            msg << times << " times total time: " << seconds << " seconds  "
                << " (avg " << average <<")";
            std::cout << msg.str() << std::endl;
        }

        void add_time(double seconds)
        {
            total += seconds;
            ++times;
            in_use = false;
        }

        bool aquire()
        {
            if (in_use)
                return false;
            in_use = true;
            return true;
        }
    };

    class one_time : boost::noncopyable {
        std::chrono::high_resolution_clock::time_point start;
        time_collector* collector;
    public:
        one_time(time_collector& tc)
        {
            if (tc.aquire()) {
                collector = &tc;
                start = std::chrono::high_resolution_clock::now();
            }
            else
                collector = 0;
        }

        ~one_time()
        {
            if (collector) {
                auto end = std::chrono::high_resolution_clock::now();
                auto duration = std::chrono::duration_cast<std::chrono::duration<double>>(end - start);
                collector->add_time(duration.count());
            }
        }
    };
}

// Usage TIME_THIS_SCOPE(XX); where XX is a C variable name (can begin with a number)
#define TIME_THIS_SCOPE(name) \
    static scope_timer::time_collector st_time_collector_##name(#name); \
    scope_timer::one_time st_one_time_##name(st_time_collector_##name)