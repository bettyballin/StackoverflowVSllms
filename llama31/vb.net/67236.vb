Imports System.DirectoryServices\n\nDim ad As New DirectoryEntry("LDAP://intranet-domain")\nDim user As DirectoryEntry = ad.Children.Find("username")