' Example: Setting Debug Info programmatically in VB.NET (usually done via project settings GUI)\nDim project As Project = ProjectCollection.GlobalProjectCollection.GetLoadedProjects("YourProject.vbproj").First()\nproject.SetProperty("DebugType", "full") ' Can be "none", "pdbonly", or "full"