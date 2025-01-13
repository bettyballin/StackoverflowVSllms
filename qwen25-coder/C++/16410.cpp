#include <sys/time.h>\n#include <sys/resource.h>\n#include <iostream>\n#include <iomanip>\n#include <stdexcept>\n\nclass StopWatch {\npublic:\n    void start() {\n        if (getrusage(RUSAGE_SELF, &m_begin) != 0 || gettimeofday(&m_tmbegin, 0) != 0) {\n            throw std::runtime_error("Failed to get initial resource usage or time.");\n        }\n    }\n\n    void stop() {\n        if (getrusage(RUSAGE_SELF, &m_end) != 0 || gettimeofday(&m_tmend, 0) != 0) {\n            throw std::runtime_error("Failed to get final resource usage or time.");\n        }\n        timeval_sub(m_end.ru_utime, m_begin.ru_utime, m_diff.ru_utime);\n        timeval_sub(m_end.ru_stime, m_begin.ru_stime, m_diff.ru_stime);\n        timeval_sub(m_tmend, m_tmbegin, m_tmdiff);\n    }\n\n    void print(std::ostream& out) const {\n        using namespace std;\n\n        timeval const& utime = m_diff.ru_utime;\n        timeval const& stime = m_diff.ru_stime;\n\n        format_time(out, utime);\n        out << "u ";\n        format_time(out, stime);\n        out << "s ";\n        format_time(out, m_tmdiff);\n    }\n\nprivate:\n    rusage m_begin;\n    rusage m_end;\n    rusage m_diff;\n    timeval m_tmbegin;\n    timeval m_tmend;\n    timeval m_tmdiff;\n\n    static void timeval_sub(const timeval &a, const timeval &b, timeval &ret) {\n        ret.tv_usec = a.tv_usec - b.tv_usec;\n        ret.tv_sec = a.tv_sec - b.tv_sec;\n        if (ret.tv_usec < 0) {\n            ret.tv_usec += 1000000;\n            --ret.tv_sec;\n        }\n    }\n\n    static void format_time(std::ostream &out, const timeval &tv) {\n        using namespace std;\n        long total_usecs = tv.tv_sec * 1000000 + tv.tv_usec;\n        out << setprecision(6) << fixed << (double)total_usecs / 1000000.0;\n    }\n};