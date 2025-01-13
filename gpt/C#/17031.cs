public class InventoryService\n    {\n        private readonly IUnitOfWork _unitOfWork;\n\n        public InventoryService(IUnitOfWork unitOfWork)\n        {\n            _unitOfWork = unitOfWork;\n        }\n\n        public void Move(string sourceLocationId, string destinationLocationId, string itemId)\n        {\n            var sourceLocation = _unitOfWork.Locations.GetById(sourceLocationId);\n            var destinationLocation = _unitOfWork.Locations.GetById(destinationLocationId);\n\n            if (sourceLocation == null || destinationLocation == null)\n                throw new InvalidOperationException("Source or Destination location not found.");\n\n            var item = _unitOfWork.Items.GetById(itemId);\n            if (item == null)\n                throw new InvalidOperationException("Item not found.");\n\n            // Perform move operation\n            sourceLocation.RemoveItem(item);\n            destinationLocation.AddItem(item);\n\n            // Commit the changes\n            _unitOfWork.Commit();\n        }\n    }