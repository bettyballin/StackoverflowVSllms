using System;\nusing System.Linq;\nusing System.Threading;\nusing System.Threading.Tasks;\n\npublic class EmailScheduler\n{\n    private readonly ApplicationDbContext _context;\n\n    public EmailScheduler(ApplicationDbContext context)\n    {\n        _context = context;\n    }\n\n    public async Task ExecuteAsync(CancellationToken cancellationToken)\n    {\n        while (!cancellationToken.IsCancellationRequested)\n        {\n            var utcNow = DateTime.UtcNow;\n\n            // Fetch users and their time zone information\n            var users = await _context.Users.ToListAsync();\n\n            foreach (var user in users)\n            {\n                TimeZoneInfo timeZoneInfo;\n                try\n                {\n                    timeZoneInfo = TimeZoneInfo.FindSystemTimeZoneById(user.TimeZoneId);\n                }\n                catch (InvalidTimeZoneException e)\n                {\n                    // Handle the exception, possibly log and continue with next user\n                    Console.WriteLine($"Invalid time zone for user {user.UserName}: {e.Message}");\n                    continue;\n                }\n\n                var localNow = TimeZoneInfo.ConvertTimeFromUtc(utcNow, timeZoneInfo);\n\n                // Check if it's 6 PM in the user's time zone\n                if (localNow.Hour == 18)\n                {\n                    SendEmail(user.UserName);\n                }\n            }\n\n            await Task.Delay(TimeSpan.FromHours(1), cancellationToken); // Run every hour\n        }\n    }\n\n    private void SendEmail(string userName)\n    {\n        // Implement email sending logic here\n        Console.WriteLine($"Sending email to {userName}");\n    }\n}