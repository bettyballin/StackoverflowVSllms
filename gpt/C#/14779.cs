public async Task<IActionResult> GetDataAsync()\n    {\n        var data = await _dataService.GetDataAsync();\n        return View(data);\n    }