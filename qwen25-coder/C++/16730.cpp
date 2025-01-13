#include <memory>\n#include <list>\n\nclass Slave;\nusing SlavePtr = std::shared_ptr<Slave>;\n\nclass Master {\nprivate:\n    std::list<SlavePtr> slaves;\n\npublic:\n    void addSlave(const SlavePtr& slave) {\n        slaves.push_front(slave);\n    }\n};\n\nint main() {\n    auto master = std::make_shared<Master>();\n    auto slave = std::make_shared<Slave>();\n    \n    master->addSlave(slave);\n\n    return 0;\n}