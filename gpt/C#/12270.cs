extern alias OldTelerik;\nextern alias NewTelerik;\n\nusing System;\nusing System.Web.UI;\n\npublic partial class MyPage : Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        OldTelerik::Telerik.Charting.ChartSeries oldChartSeries = new OldTelerik::Telerik.Charting.ChartSeries();\n        NewTelerik::Telerik.Web.UI.RadEditor newRadEditor = new NewTelerik::Telerik.Web.UI.RadEditor();\n        \n        // Use oldChartSeries and newRadEditor in your code...\n    }\n}