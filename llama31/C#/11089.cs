private void button1_Click(object sender, EventArgs e)\n{\n    List<string> codecs = VideoCodecEnumerator.EnumerateVideoCodecs();\n    listBox1.DataSource = codecs;\n}