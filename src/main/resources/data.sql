INSERT INTO roles (role_id, role_name, is_deleted) VALUES
(1, 'ADMIN', 0),
(2, 'FLIGHT_OWNER', 0),
(3, 'FLIGHT_MANAGER', 0),
(4, 'USER', 0)
ON DUPLICATE KEY UPDATE role_name = VALUES(role_name);