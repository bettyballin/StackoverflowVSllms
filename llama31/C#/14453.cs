string generatedEmail = $"{facebookUserId}@yourdomain.com";\nMembershipService.CreateUser(username, password, generatedEmail);