using System;\nusing System.Xml;\nusing System.Xml.XPath;\n\nclass Program\n{\n    static void Main()\n    {\n        string xml = @"<?xml version=""1.0"" encoding=""utf-8""?>\n<Project xmlns=""http://schemas.microsoft.com/developer/msbuild/2003"">\n    <!-- $Id: FxCop.proj 114 2006-03-14 06:32:46Z pwelter34 $ -->\n    <PropertyGroup>\n        <MSBuildCommunityTasksPath>$(MSBuildProjectDirectory)\MSBuild.Community.Tasks\bin\Debug</MSBuildCommunityTasksPath>\n    </PropertyGroup>\n    <Import\n        Project=""$(MSBuildProjectDirectory)\MSBuild.Community.Tasks\MSBuild.Community.Tasks.Targets"" />\n    <Target Name=""DoFxCop"">\n        <FxCop TargetAssemblies=""$(MSBuildCommunityTasksPath)\MSBuild.Community.Tasks.dll""\n            RuleLibraries=""@(FxCopRuleAssemblies)"" \n            AnalysisReportFileName=""Test.html""\n            DependencyDirectories=""$(MSBuildCommunityTasksPath)"" \n            FailOnError=""True""\n            ApplyOutXsl=""True""\n            OutputXslFileName=""C:\Program Files\Microsoft FxCop 1.32\Xml\FxCopReport.xsl"" />\n    </Target>\n</Project>";\n\n        XmlDocument xmlDoc = new XmlDocument();\n        xmlDoc.LoadXml(xml);\n\n        XmlNamespaceManager nsmgr = new XmlNamespaceManager(xmlDoc.NameTable);\n        string namespaceURI = "http://schemas.microsoft.com/developer/msbuild/2003";\n        nsmgr.AddNamespace("msb", namespaceURI);\n\n        // Use the prefix 'msb' defined in the nsmgr\n        XPathExpression expr = xmlDoc.CreateNavigator().Compile("//msb:PropertyGroup");\n        expr.SetContext(nsmgr);\n\n        XPathNodeIterator nodes = xmlDoc.CreateNavigator().Select(expr);\n        while (nodes.MoveNext())\n        {\n            Console.WriteLine(nodes.Current.OuterXml);\n        }\n    }\n}