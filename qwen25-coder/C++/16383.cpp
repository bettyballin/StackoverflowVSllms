#include <map>\n#include <set>\n\nclass Foo {\n    // Your class definition\n};\n\nclass ID {\n    // Your class definition\n};\n\nstd::map<Foo*, std::set<ID*>> fooToIDs;  // Primary map\nstd::map<ID*, Foo*> idToFoos;             // Auxiliary reverse map\n\nvoid associateIDWithFoo(ID* pID, Foo* pFoo) {\n    fooToIDs[pFoo].insert(pID);\n    idToFoos[pID] = pFoo;\n}\n\nvoid disassociateIDFromFoo(ID* pID) {\n    if (idToFoos.find(pID) != idToFoos.end()) {\n        Foo* associatedFoo = idToFoos[pID];\n        fooToIDs[associatedFoo].erase(pID);\n        // Optionally remove the entry from idToFoos if no more IDs are mapped to this Foo\n        if (fooToIDs[associatedFoo].empty()) {\n            fooToIDs.erase(associatedFoo);\n        }\n        idToFoos.erase(pID);\n    }\n}\n\nvoid FindXXX(const ID* pID) {\n    auto it = idToFoos.find(pID);\n    if (it != idToFoos.end()) {\n        Foo* containingFoo = it->second;\n        // Do something with containingFoo\n    } else {\n        // Handle not found case\n    }\n}