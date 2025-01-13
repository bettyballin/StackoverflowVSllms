import { Grid } from 'ag-grid-community';\nimport 'ag-grid-community/styles/ag-grid.css';\nimport 'ag-grid-community/styles/ag-theme-alpine.css';\n\nconst columnDefs = [\n  { field: 'status', sortable: true },\n  { field: 'priority', sortable: true, sort: 'desc' },\n  { field: 'date', sortable: true, sort: 'asc' },\n];\n\nconst rowData = [\n  { status: 'Open', priority: 'High', date: '2023-01-01' },\n  { status: 'Closed', priority: 'Low', date: '2023-01-02' },\n  // more data rows...\n];\n\nconst gridOptions = {\n  columnDefs: columnDefs,\n  rowData: rowData,\n  defaultColDef: {\n    sortable: true,\n  },\n};\n\ndocument.addEventListener('DOMContentLoaded', () => {\n  const gridDiv = document.querySelector('#myGrid');\n  new Grid(gridDiv, gridOptions);\n});