public interface IUserProfileView {\n    event EventHandler<UserEventArgs> UserProfileUpdated;\n    void DisplayUserProfile(User profile);\n}