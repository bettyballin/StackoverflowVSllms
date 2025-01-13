public async Task ApproveFormsAsync(List<int> formIds)\n   {\n       var forms = await _formRepository.GetFormsByIdsAsync(formIds);\n       foreach (var form in forms)\n       {\n           form.IsApproved = true;\n           await _emailService.SendApprovalEmailAsync(form);\n       }\n       await _formRepository.SaveChangesAsync();\n   }