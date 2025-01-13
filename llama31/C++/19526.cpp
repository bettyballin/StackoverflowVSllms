int main()\n{\n    // Create a sample vector of InventoryItem structs\n    vector<InventoryItem> items = {\n        {"Item1", "Description1", 10, 20, 30, 40},\n        {"Item2", "Description2", 50, 60, 70, 80}\n    };\n\n    // Write the vector to a file\n    ofstream out("data.dat");\n    writeVector(out, items);\n    out.close();\n\n    // Read the vector from the file\n    ifstream in("data.dat");\n    vector<InventoryItem> readItems = readVector<InventoryItem>(in);\n    in.close();\n\n    // Print the read vector\n    for (const auto& item : readItems) {\n        cout << item.Item << " " << item.Description << " " << item.Quantity << " " << item.wholesaleCost << " " << item.retailCost << " " << item.dateAdded << endl;\n    }\n\n    return 0;\n}