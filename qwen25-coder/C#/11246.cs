[WebMethod]\n    public List<StorageObject> GetStorageObjects() {\n        List<StorageObject> o = new List<StorageObject>() {\n            new StorageObject() { \n                Name = "Matthew",\n                Birthday = "Jan 1st, 2008", \n                OtherInfo = new OtherInfo() { Data = {\n                    { "Hobbies", "Programming" },\n                    { "Website", "Stackoverflow.com" }\n                }}\n            },\n            new StorageObject() { \n                Name = "Joe",\n                Birthday = "Jan 10th,2008",\n                OtherInfo = new OtherInfo() { Data = {\n                    { "Hobbies", "Programming" },\n                    { "Website", "Stackoverflow.com" }\n                }}\n            }\n        };\n\n        return o;\n    }