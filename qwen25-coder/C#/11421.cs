public partial class YourEntityClass {\n    public YourEntityClass() {\n        // Set default values for fields with DB defaults here.\n        this.YourBitField = true; // Example value matching the SQL Server default (1).\n    }\n\n    partial void OnYourEntityClassChanging(YourEntityClass original) {\n        if (!original.IsLoaded) {\n            // Handle logic when loading entities.\n        }\n    }\n\n    partial void OnYourEntityClassInserted() {\n        // Optional: Logic upon successful insertion can be handled here.\n    }\n\n    partial void OnYourEntityClassUpdating() {\n        // Optional: Update any necessary fields before updating an entity.\n    }\n}