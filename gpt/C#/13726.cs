public partial class User\n{\n    // Assuming DataContext is your LINQ to SQL data context class\n    private DataContext db = new DataContext();\n\n    public string FirstName\n    {\n        get\n        {\n            return GetUserDataValue("FirstName");\n        }\n        set\n        {\n            SetUserDataValue("FirstName", value);\n        }\n    }\n\n    public string LastName\n    {\n        get\n        {\n            return GetUserDataValue("LastName");\n        }\n        set\n        {\n            SetUserDataValue("LastName", value);\n        }\n    }\n\n    private string GetUserDataValue(string keyName)\n    {\n        var userData = db.UserDatas.SingleOrDefault(ud => ud.ItemID == this.UserID && ud.KeyName == keyName);\n        return userData != null ? userData.Value : string.Empty;\n    }\n\n    private void SetUserDataValue(string keyName, string value)\n    {\n        var userData = db.UserDatas.SingleOrDefault(ud => ud.ItemID == this.UserID && ud.KeyName == keyName);\n        if (userData != null)\n        {\n            userData.Value = value;\n        }\n        else\n        {\n            db.UserDatas.InsertOnSubmit(new UserData\n            {\n                ItemID = this.UserID,\n                KeyName = keyName,\n                Value = value\n            });\n        }\n        db.SubmitChanges();\n    }\n}