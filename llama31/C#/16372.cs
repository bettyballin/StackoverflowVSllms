MembershipUser newUser = Membership.CreateUser(username, password, email);\nnewUser.CreateDate = DateTime.Now;\nMembership.UpdateUser(newUser);