public class ApplicationUserManager : UserManager<ApplicationUser>\n   {\n       public ApplicationUserManager(IUserStore<ApplicationUser> store) : base(store) { }\n\n       public static ApplicationUserManager Create(IdentityFactoryOptions<ApplicationUserManager> options, IOwinContext context)\n       {\n           var manager = new ApplicationUserManager(new UserStore<ApplicationUser>(context.Get<ApplicationDbContext>()));\n           // Configure user manager settings here\n           return manager;\n       }\n   }