string sql = "SELECT [WallPost], [DatePosted] FROM [WallTable] WHERE [UserId] = @UserId";\n\nstring strCon = System.Web.Configuration.WebConfigurationManager.ConnectionStrings["SocialSiteConnectionString"].ConnectionString;\n\nSqlConnection conn = new SqlConnection(strCon);\n\nSqlDataAdapter daUserProfile = new SqlDataAdapter(sql, conn);\n\ndaUserProfile.SelectCommand.Parameters.AddWithValue("@UserId", Request["friend"]);\n\ndsSocialSite.UserProfileDataTable tbUserProfile = new dsSocialSite.UserProfileDataTable();\n\ndaUserProfile.Fill(tbUserProfile);\n\nrpWall2.DataSource = tbUserProfile; //rpWall2 = repeater control\n\nrpWall2.DataBind();