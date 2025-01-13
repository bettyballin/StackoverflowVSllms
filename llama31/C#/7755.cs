public class TimesheetEntry\n{\n    public int TaskId { get; set; }\n    public DateTime StartTime { get; set; }\n    public DateTime EndTime { get; set; }\n    public int TimesheetId { get; set; }\n}\n\npublic class Task\n{\n    public int TaskId { get; set; }\n    public string TaskName { get; set; }\n}\n\npublic class TimesheetResult\n{\n    public string TaskName { get; set; }\n    public int Sunday { get; set; }\n    public int Monday { get; set; }\n    public int Tuesday { get; set; }\n    public int Wednesday { get; set; }\n    public int Thursday { get; set; }\n    public int Friday { get; set; }\n    public int Saturday { get; set; }\n}\n\npublic IEnumerable<TimesheetResult> GetTimesheetForWeekById(\n    int timesheetId,\n    DateTime beginDate,\n    DateTime endDate)\n{\n    var tasks = db.Tasks;\n    var timeEntries = db.TimeEntries\n        .Where(te => te.TimesheetId == timesheetId\n            && te.StartTime >= beginDate\n            && te.StartTime <= endDate);\n\n    var results = from t in tasks\n                  join te in timeEntries on t.TaskId equals te.TaskId\n                  group te by t.TaskName into g\n                  select new TimesheetResult\n                  {\n                      TaskName = g.Key,\n                      Sunday = g.Sum(te => te.StartTime.DayOfWeek == DayOfWeek.Sunday ? (te.EndTime - te.StartTime).TotalMinutes : 0),\n                      Monday = g.Sum(te => te.StartTime.DayOfWeek == DayOfWeek.Monday ? (te.EndTime - te.StartTime).TotalMinutes : 0),\n                      Tuesday = g.Sum(te => te.StartTime.DayOfWeek == DayOfWeek.Tuesday ? (te.EndTime - te.StartTime).TotalMinutes : 0),\n                      Wednesday = g.Sum(te => te.StartTime.DayOfWeek == DayOfWeek.Wednesday ? (te.EndTime - te.StartTime).TotalMinutes : 0),\n                      Thursday = g.Sum(te => te.StartTime.DayOfWeek == DayOfWeek.Thursday ? (te.EndTime - te.StartTime).TotalMinutes : 0),\n                      Friday = g.Sum(te => te.StartTime.DayOfWeek == DayOfWeek.Friday ? (te.EndTime - te.StartTime).TotalMinutes : 0),\n                      Saturday = g.Sum(te => te.StartTime.DayOfWeek == DayOfWeek.Saturday ? (te.EndTime - te.StartTime).TotalMinutes : 0)\n                  };\n\n    return results;\n}