const string format = "o";\nvar time = new DateTime(2008, 12, 19, 17, 24, 18, 0, DateTimeKind.Utc);\nvar actual = time.ToString(format, CultureInfo.InvariantCulture);