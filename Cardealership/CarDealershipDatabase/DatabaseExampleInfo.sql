-- Insert sample data into dealerships
INSERT INTO dealerships (name, address, phone) VALUES
('Lisha Tech', '222 Tech Drive, New York', '222-7890'),
('Bronx City Motors', '5678 Pelham Parkway, Bronx', '555-1234');

-- Insert sample data into vehicles
INSERT INTO vehicles (VIN, make, model, year, color, price) VALUES
('1HGCM82633A004352', 'Honda', 'Accord', 2023, 'Black', 24000.00),
('JH4KA9650MC012345', 'Acura', 'TL', 2022, 'White', 35000.00);

-- Insert sample data into inventory
INSERT INTO inventory (dealership_id, VIN) VALUES
(1, '1HGCM82633A004352'),
(2, 'JH4KA9650MC012345');

-- Insert sample data into sales_contracts
INSERT INTO sales_contracts (VIN, customer_name, sales_date, price_sold) VALUES
('1HGCM82633A004352', 'Derek Jeter', '2024-06-10', 23000.00);