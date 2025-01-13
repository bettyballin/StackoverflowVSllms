class CubicSpline {\n  constructor(points) {\n    this.points = points;\n    this.n = points.length;\n    this.a = new Array(this.n);\n    this.b = new Array(this.n);\n    this.c = new Array(this.n);\n    this.d = new Array(this.n);\n    this.alpha = new Array(this.n);\n    this.h = new Array(this.n);\n\n    for (let i = 0; i < this.n; ++i) {\n      this.a[i] = points[i][1];\n    }\n\n    for (let i = 1; i < this.n; ++i) {\n      this.h[i] = points[i][0] - points[i - 1][0];\n    }\n\n    for (let i = 1; i < this.n - 1; ++i) {\n      this.alpha[i] = (3 / this.h[i + 1]) * (this.a[i + 1] - this.a[i]) - (3 / this.h[i]) * (this.a[i] - this.a[i - 1]);\n    }\n\n    this.c[0] = 0;\n    this.c[this.n - 1] = 0;\n\n    for (let i = 1; i < this.n - 1; ++i) {\n      let A = this.h[i + 1], B = this.h[i], C = 2 * (this.h[i] + this.h[i + 1]);\n      this.c[i] = (this.alpha[i] - A * this.c[i - 1]) / C;\n    }\n\n    for (let i = this.n - 2; i >= 0; --i) {\n      this.c[i] = this.c[i] - (this.h[i + 1] * this.c[i + 1]) / (this.h[i] + this.h[i + 1]);\n    }\n\n    for (let i = 1; i < this.n; ++i) {\n      this.b[i] = (this.a[i] - this.a[i - 1]) / this.h[i] - (this.h[i] / 3) * (this.c[i] + 2 * this.c[i - 1]);\n      this.d[i] = (this.c[i] - this.c[i - 1]) / (3 * this.h[i]);\n    }\n  }\n\n  interpolate(x) {\n    let i = 0;\n    while (this.points[i + 1][0] < x) i++;\n\n    let h = x - this.points[i][0];\n    return this.a[i] + this.b[i + 1] * h + this.c[i] * h * h + this.d[i + 1] * h * h * h;\n  }\n}\n\n// Example usage\nlet points = [[1, 100], [5, 120], [10, 110]]; // Example points (time, glucose level)\nlet spline = new CubicSpline(points);\nconsole.log(spline.interpolate(3)); // Interpolate glucose level at time 3