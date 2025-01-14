pp
#include <uuid/uuid.h>
#include <string.h>

// Define a struct to hold the model type and its corresponding GUID
struct ModelGuid {
    const char* modelType;
    uuid_t guid;
};

// Define the GUIDs for each model type
ModelGuid modelGuids[] = {
    {"Model1", { /* insert GUID for Model1 here */ }},
    {"Model2", { /* insert GUID for Model2 here */ }},
    // ... add more model types here ...
};

// Function to get the GUID for a given model type
uuid_t getModelGuid(const char* modelType) {
    for (ModelGuid& mg : modelGuids) {
        if (strcmp(modelType, mg.modelType) == 0) {
            return mg.guid;
        }
    }
    // Return a default or error GUID if model type not found
    uuid_t defaultGuid;
    uuid_clear(defaultGuid);
    return defaultGuid;
}

int main() {
    const char* modelType = "Model1";
    uuid_t classId = getModelGuid(modelType);

    // Create an instance of the unit model
    // Note: IUnitModelPtr and CreateInstance are not standard C++ classes/functions
    // You will need to implement or replace these with your own code
    IUnitModelPtr unit;
    unit.CreateInstance(classId);

    // Interface methods can be called here

    return 0;
}