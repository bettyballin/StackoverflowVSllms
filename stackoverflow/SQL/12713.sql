select j.email \nfrom jobseeker j\nwhere j.email not in (select email from aspnet_Membership\n                      where email is not null)