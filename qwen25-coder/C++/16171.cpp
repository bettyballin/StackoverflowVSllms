struct routing_entry {\n    unsigned long destSeq;  // 32 bits\n    unsigned long nextHop;  // 32 bits\n    unsigned char hopCount; // 8 bits\n\n    // Add a default constructor to initialize the struct to an "empty" state\n    routing_entry() : destSeq(0), nextHop(0), hopCount(0) {}\n    \n    // Optionally, add a method to check if the entry is uninitialized\n    bool isValid() const {\n        return destSeq != 0 || nextHop != 0 || hopCount != 0;\n    }\n};\n\nrouting_entry Cnode_router_aodv::consultTable(unsigned int destinationID ) {  \n    routing_entry route; // Uses default constructor, sets to "empty" state\n\n    auto it = routing_table.find(destinationID);\n    if (it != routing_table.end())\n        route = it->second;\n\n    return route; \n}\n\n// Usage of consultTable\nvoid exampleUsage() {\n    Cnode_router_aodv router;\n    unsigned int id = 12345;\n    routing_entry route = router.consultTable(id);\n\n    if (route.isValid()) {\n        // The route was found and is valid\n    } else {\n        // The route was not found\n    }\n}