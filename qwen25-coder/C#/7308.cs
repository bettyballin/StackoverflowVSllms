// Example of basic document retrieval in Kentico\n   var documentUrlPath = "/News/Press-Releases";\n   TreeProvider treeProvider = new TreeProvider(MembershipContext.AuthenticatedUser);\n   TreeNode node = treeProvider.SelectSingleNode(SiteContext.CurrentSiteName, documentUrlPath, SiteContext.LanguageName);