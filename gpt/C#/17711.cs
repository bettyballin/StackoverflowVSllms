protected void lbtnUpdate_Click(object sender, EventArgs e)\n{\n    if (this.RadDock1.Closed)\n        this.RadDock1.Closed = false;\n    else\n        this.RadDock1.Closed = true;\n}