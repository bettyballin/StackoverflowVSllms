// MyApp.Api\n[ApiController]\npublic class WhateverController : ControllerBase\n{\n    private readonly WhateverRepository _repository;\n\n    public WhateverController(WhateverRepository repository)\n    {\n        _repository = repository;\n    }\n\n    [HttpPost]\n    public IActionResult CreateWhatever(Whatever whatever)\n    {\n        _repository.Save(whatever);\n        return CreatedAtAction(nameof(CreateWhatever), whatever);\n    }\n}