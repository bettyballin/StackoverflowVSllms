using ADI.Settings;\n\npublic class MyClassInLibrary\n{\n    public void SomeMethod()\n    {\n        string imageRoot = MyApplicationSettings.Default.ADIImageRoot;\n        string variantsRoot = MyApplicationSettings.Default.ADIImageVariantsRoot;\n\n        // Use the settings values...\n    }\n}