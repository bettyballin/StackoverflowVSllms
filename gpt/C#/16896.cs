protected void _Build_Click(object sender, EventArgs e)\n{\n    if (Build.IsBuilding) return;\n\n    BackgroundJob.Enqueue(() => Build.DoBuild());\n}