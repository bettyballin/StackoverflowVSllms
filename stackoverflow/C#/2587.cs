public class Interval\n{\n    public Interval(int state)\n    {\n        this.State = state;\n        this.Duration = -1; \n        this.Date = DateTime.MinValue;\n    }\n    public DateTime Date;\n    public long Duration; \n    public int State; \n}\n\nclass StateSummary\n{\n    public StateSummary(StateEnum state, long totalSeconds)\n    {   \n        State = (int)state;\n        TotalSeconds = totalSeconds;\n    }\n    public int State;\n    public long TotalSeconds; \n}\n\nInterval[] GetRandomIntervals(DateTime start, DateTime end, StateSummary[] sums, int totalEvents)\n{\n    Random r = new Random(); \n    ArrayList intervals = new ArrayList();\n\n    for (int i=0; i < sums.Length; i++)\n    {\n        intervals.Add(new Interval(sums[i].State));\n    }\n\n    for (int i=0; i < totalEvents - sums.Length; i++)\n    {\n        intervals.Add(new Interval(sums[r.Next(0,sums.Length)].State));\n    }\n\n    Hashtable eventCounts = new Hashtable();\n    foreach (Interval interval in intervals)\n    {\n        if (eventCounts[interval.State] == null) \n        {\n            eventCounts[interval.State] = 1; \n        }\n        else \n        {\n            eventCounts[interval.State] = ((int)eventCounts[interval.State]) + 1;\n        }\n    }\n\n    foreach(StateSummary sum in sums)\n    {\n        long avgDuration = sum.TotalSeconds / (int)eventCounts[sum.State];\n        foreach (Interval interval in intervals) \n        {\n            if (interval.State == sum.State)\n            {\n                long offset = ((long)(r.NextDouble() * avgDuration)) - (avgDuration / 2); \n                interval.Duration = avgDuration + offset; \n            }\n        }\n    } \n\n    // cap the durations. \n    Hashtable eventTotals = new Hashtable();\n    foreach (Interval interval in intervals)\n    {\n        if (eventTotals[interval.State] == null) \n        {\n            eventTotals[interval.State] = interval.Duration; \n        }\n        else \n        {\n            eventTotals[interval.State] = ((long)eventTotals[interval.State]) + interval.Duration;\n        }\n    }\n\n    foreach(StateSummary sum in sums)\n    {\n        long diff = sum.TotalSeconds - (long)eventTotals[sum.State];\n        if (diff != 0)\n        {\n            long diffPerInterval = diff / (int)eventCounts[sum.State]; \n            long mod = diff % (int)eventCounts[sum.State];\n            bool first = true;\n            foreach (Interval interval in intervals) \n            {\n                if (interval.State == sum.State)\n                {\n                    interval.Duration += diffPerInterval;\n                    if (first) \n                    {\n                        interval.Duration += mod;\n                        first = false;\n                    }\n\n                }\n            }\n        }\n    }\n\n    Shuffle(intervals);\n\n    DateTime d = start; \n    foreach (Interval interval in intervals) \n    {\n        interval.Date = d; \n        d = d.AddSeconds(interval.Duration);\n    }\n\n    return (Interval[])intervals.ToArray(typeof(Interval));\n}\n\npublic static ICollection Shuffle(ICollection c)\n{\n    Random rng = new Random();\n    object[] a = new object[c.Count];\n    c.CopyTo(a, 0);\n    byte[] b = new byte[a.Length];\n    rng.NextBytes(b);\n    Array.Sort(b, a);\n    return new ArrayList(a);\n}