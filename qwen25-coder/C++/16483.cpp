#include <tbb/task_scheduler_init.h>\n#include <tbb/parallel_for.h>\n#include <iostream>\n\nusing namespace tbb;\n\nvoid parallel_task(size_t i) {\n    // Example task processing\n    std::cout << "Processing chunk: " << i << std::endl;\n}\n\nint main() {\n    task_scheduler_init init; // Initialize TBB scheduler\n\n    size_t num_chunks = 1024;\n    parallel_for(blocked_range<size_t>(0, num_chunks), [&](const blocked_range<size_t>& r){\n        for (size_t i = r.begin(); i != r.end(); ++i) {\n            parallel_task(i);\n        }\n    });\n\n    return 0;\n}