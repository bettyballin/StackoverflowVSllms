pp
#include <list>
#include <boost/shared_ptr.hpp>
#include <iostream>

class Element {
public:
    std::list<boost::shared_ptr<Element> > children;

    void addChild(boost::shared_ptr<Element> child) {
        children.push_back(child);
    }

    void printChildren() {
        std::cout << "Number of children: " << children.size() << std::endl;
    }
};

int main() {
    boost::shared_ptr<Element> parent(new Element());
    boost::shared_ptr<Element> child(new Element());

    parent->addChild(child);
    parent->printChildren();

    return 0;
}