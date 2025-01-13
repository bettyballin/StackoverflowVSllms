using Microsoft.Graph;\nusing System.Net.Http.Headers;\n\n// ...\n\nvar graphClient = new GraphServiceClient(\n    new DelegateAuthenticationProvider(\n        (requestMessage) =>\n        {\n            var token = GetAccessTokenAsync();\n            requestMessage.Headers.Authorization = new AuthenticationHeaderValue("Bearer", token);\n            return Task.CompletedTask;\n        }));\n\nvar eventItem = new Event\n{\n    Subject = "Test Event",\n    Body = new ItemBody\n    {\n        Content = "Test event body",\n        ContentType = BodyType.Text,\n    },\n    Start = new DateTimeTimeZone\n    {\n        DateTime = DateTime.Now.AddDays(30).ToString("yyyy-MM-ddTHH:mm:ss"),\n        TimeZone = "Pacific Standard Time",\n    },\n    End = new DateTimeTimeZone\n    {\n        DateTime = DateTime.Now.AddDays(30).AddHours(1).ToString("yyyy-MM-ddTHH:mm:ss"),\n        TimeZone = "Pacific Standard Time",\n    },\n};\n\nawait graphClient.Me.Events.Request().AddAsync(eventItem);