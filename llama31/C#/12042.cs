// Get the latest revision number\nvar info = client.GetInfo(repositoryUrl);\nint latestRevision = info.Revision;