public class Tracker\n{\n    private HttpSessionState _session;\n\n    public Tracker(HttpSessionState session)\n    {\n        _session = session;\n    }\n\n    public void LogActivity(string activityDescription)\n    {\n        // Example: store activity in a list in session\n        var activities = (List<string>)_session["UserActivities"] ?? new List<string>();\n        activities.Add(activityDescription);\n        _session["UserActivities"] = activities;\n\n        // Optionally save to database on each log\n        SaveToDatabase(activityDescription);\n    }\n\n    public void SaveAll_activities()\n    {\n        var activities = (List<string>)_session["UserActivities"] ?? new List<string>();\n        foreach (var activity in activities)\n        {\n            SaveToDatabase(activity); // Implement this method to save data to your database\n        }\n        _session.Remove("UserActivities");\n    }\n\n    private void SaveToDatabase(string activityDescription)\n    {\n        // Your code to save activityDescription to the database\n    }\n}