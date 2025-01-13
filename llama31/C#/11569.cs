[Table("Charts")]\npublic abstract class Chart {\n    public int ChartId { get; set; }\n    public int ReportId { get; set; }\n}\n\n[Table("LineCharts")]\npublic class LineChart : Chart {\n    public int Thickness { get; set; }\n    public int YAxis { get; set; }\n    public int XAxis { get; set; }\n    public string Color { get; set; }\n}\n\n[Table("PieCharts")]\npublic class PieChart : Chart {\n    public int Radius { get; set; }\n    public string Color { get; set; }\n}\n\n[Table("BarCharts")]\npublic class BarChart : Chart {\n    public int Width { get; set; }\n    public int Border { get; set; }\n}