using System;\nusing System.Xml;\nusing System.Xml.XPath;\n\nclass Program\n{\n    static void Main()\n    {\n        string xml = @"<?xml version=""1.0"" encoding=""utf-8""?>\n<Project xmlns=""http://schemas.microsoft.com/developer/msbuild/2003"">\n    <!-- $Id: FxCop.proj 114 2006-03-14 06:32:46Z pwelter34 $ -->\n    <PropertyGroup>\n        <MSBuildCommunityTasksPath>$(MSBuildProjectDirectory)\MSBuild.Community.Tasks\bin\Debug</MSBuildCommunityTasksPath>\n    </PropertyGroup>\n    <Import\n        Project=""$(MSBuildProjectDirectory)\MSBuild.Community.Tasks\MSBuild.Community.Tasks.Targets"" />\n    <Target Name=""DoFxCop"">\n        <FxCop TargetAssemblies=""$(MSBuildCommunityTasksPath)\MSBuild.Community.Tasks.dll""\n            RuleLibraries=""@(FxCopRuleAssemblies)"" \n            AnalysisReportFileName=""Test.html""\n            DependencyDirectories=""$(MSBuildCommunityTasksPath)"" \n            FailOnError=""True""\n            ApplyOutXsl=""True""\n            OutputXslFileName=""C:\Program Files\Microsoft FxCop 1.32\Xml\FxCopReport.xsl"" />\n    </Target>\n</Project>";\n\n        XmlDocument doc = new XmlDocument();\n        doc.LoadXml(xml);\n\n        XmlNamespaceManager nsmgr = new XmlNamespaceManager(doc.NameTable);\n        nsmgr.AddNamespace("msb", "http://schemas.microsoft.com/developer/msbuild/2003");\n\n        XmlNodeList nodes = doc.SelectNodes("//msb:PropertyGroup", nsmgr);\n        foreach (XmlNode node in nodes)\n        {\n            Console.WriteLine(node.OuterXml);\n        }\n    }\n}