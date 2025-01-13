#include <iostream>\n#include <thread>\n#include <mutex>\n#include <condition_variable>\n\nclass Monitor {\nprivate:\n    std::mutex mtx;\n    std::condition_variable cv;\n\npublic:\n    void enter() {\n        mtx.lock();\n    }\n\n    void leave() {\n        mtx.unlock();\n    }\n\n    void wait() {\n        std::unique_lock<std::mutex> lock(mtx);\n        cv.wait(lock);\n    }\n\n    void signal_one() {\n        cv.notify_one();\n    }\n};\n\nvoid ThreadProc(Monitor* monitor) {\n    monitor->enter();\n    std::cout << "Thread waiting..." << std::endl;\n    monitor->wait();\n    std::cout << "Thread signaled and exiting..." << std::endl;\n    monitor->leave();\n}\n\nint main() {\n    Monitor monitor;\n\n    std::thread threads[2];\n    for (auto& th : threads) {\n        th = std::thread(ThreadProc, &monitor);\n    }\n\n    std::this_thread::sleep_for(std::chrono::seconds(1)); // Let threads wait\n\n    monitor.enter();\n    std::cout << "Main thread signaling one..." << std::endl;\n    monitor.signal_one();\n    monitor.leave();\n\n    for (auto& th : threads) {\n        th.join();\n    }\n\n    return 0;\n}