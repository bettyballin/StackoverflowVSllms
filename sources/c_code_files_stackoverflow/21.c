#include <stdio.h>
#include <string.h>
#include <dirent.h>

// Define AnsiString as a type alias for char*
typedef char* AnsiString;

// Define TDataSet and TField as struct types
typedef struct TDataSet {
    void (*Append)(struct TDataSet*);
    void (*Post)(struct TDataSet*);
    struct TField* (*FieldByName)(struct TDataSet*, const char*);
} TDataSet;

typedef struct TField {
    void (*SetValue)(struct TField*, const char*);
} TField;

// Function pointer types
typedef void (*AppendFunc)(TDataSet*);
typedef void (*PostFunc)(TDataSet*);
typedef TField* (*FieldByNameFunc)(TDataSet*, const char*);
typedef void (*SetValueFunc)(TField*, const char*);

// Define the AddFiles function
void AddFiles(AnsiString path, TDataSet *DataSet)
{
    DIR* dir;
    struct dirent* ent;
    char fullPath[256];

    // Open the directory
    dir = opendir(path);
    if (dir != NULL) {
        while ((ent = readdir(dir)) != NULL) {
            // Skip current and parent directories
            if (strcmp(ent->d_name, ".") == 0 || strcmp(ent->d_name, "..") == 0) {
                continue;
            }

            // Construct the full path
            sprintf(fullPath, "%s/%s", path, ent->d_name);

            // Check if the entry is a directory
            DIR* subDir = opendir(fullPath);
            if (subDir != NULL) {
                // Recursively call AddFiles for directories
                AddFiles(fullPath, DataSet);
                closedir(subDir);
            } else {
                // Add the file to the dataset
                DataSet->Append();
                TField* field = DataSet->FieldByName("Name");
                field->SetValue(field, ent->d_name);
                /* other fields ... */
                DataSet->Post();
            }
        }
        closedir(dir);
    }
}

int main() {
    // Example usage
    TDataSet dataset;
    dataset.Append = (AppendFunc)printf;
    dataset.Post = (PostFunc)printf;
    dataset.FieldByName = (FieldByNameFunc)printf;

    TField field;
    field.SetValue = (SetValueFunc)printf;

    AnsiString path = "/path/to/directory";
    AddFiles(path, &dataset);

    return 0;
}