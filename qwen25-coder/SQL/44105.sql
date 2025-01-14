CREATE PROCEDURE GetCalculatedBounds\n    @RunID INT\nAS\nBEGIN\n    -- Select the run details for the given RunID\n    WITH ProductionDetails AS (\n        SELECT \n            pr.ContainerName,\n            pr.ProductName,\n            pr.TemplateID\n        FROM \n            ProductionRuns pr\n        WHERE \n            pr.RunID = @RunID\n    ),\n    -- Collect all qualifying bounds for the given template and container/product details\n    QualifyingBounds AS (\n        SELECT \n            tm.MeasurementTypeID,\n            COALESCE(sb.UpperBound, cb.UpperBound, pb.UpperBound) AS UpperBoundCandidate,\n            COALESCE(sb.LowerBound, cb.LowerBound, pb.LowerBound) AS LowerBoundCandidate\n        FROM \n            TemplateMeasurements tm\n        LEFT JOIN \n            SimpleBounds sb ON tm.TemplateID = @RunID AND tm.MeasurementTypeID = sb.MeasurementTypeID AND tm.TemplateID = sb.TemplateID\n        LEFT JOIN \n            ContainerBounds cb ON tm.TemplateID = cb.TemplateID AND tm.MeasurementTypeID = cb.MeasurementTypeID AND cb.ContainerName = pd.ContainerName\n        LEFT JOIN \n            ProductBounds pb ON tm.TemplateID = pb.TemplateID AND tm.MeasurementTypeID = pb.MeasurementTypeID AND pb.ProductName = pd.ProductName\n        CROSS JOIN \n            ProductionDetails pd\n    ),\n    -- Calculate the tightest bounds for each MeasurementTypeID\n    CalculatedBounds AS (\n        SELECT \n            MeasurementTypeID,\n            MIN(UpperBoundCandidate) AS CalculatedUpperBound,\n            MAX(LowerBoundCandidate) AS CalculatedLowerBound\n        FROM \n            QualifyingBounds\n        GROUP BY \n            MeasurementTypeID\n        HAVING \n            COUNT(MeasurementTypeID) > 0 -- Ensures there's at least one qualifying bound\n    )\n    -- Select the final results\n    SELECT \n        cb.MeasurementTypeID,\n        cb.CalculatedUpperBound,\n        cb.CalculatedLowerBound\n    FROM \n        CalculatedBounds cb;\nEND;