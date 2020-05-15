-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.12-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando datos para la tabla appcocina.alimento: ~1 rows (aproximadamente)
DELETE FROM `alimento`;
/*!40000 ALTER TABLE `alimento` DISABLE KEYS */;
INSERT INTO `alimento` (`nombre_alimento`, `cantidad`) VALUES
	('Pan', 20);
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.alimento_x_servicio: ~0 rows (aproximadamente)
DELETE FROM `alimento_x_servicio`;
/*!40000 ALTER TABLE `alimento_x_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `alimento_x_servicio` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.catador: ~2 rows (aproximadamente)
DELETE FROM `catador`;
/*!40000 ALTER TABLE `catador` DISABLE KEYS */;
INSERT INTO `catador` (`criterio`, `email`, `contraseña`, `nombre`, `apellidos`, `ciudad`, `telefono`, `experiencia`) VALUES
	(6, 'email2@gmail.com', 'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 'Sevilla', 'Juanito', 'Sevilla', 'Personaje', '123456789'),
	(5, 'email@gmail.com', 'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 'Sevilla', 'Alfonso', 'Sevilla', 'Ramirez', '123456789');
/*!40000 ALTER TABLE `catador` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.catador_x_servicio: ~0 rows (aproximadamente)
DELETE FROM `catador_x_servicio`;
/*!40000 ALTER TABLE `catador_x_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `catador_x_servicio` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.cocinero: ~2 rows (aproximadamente)
DELETE FROM `cocinero`;
/*!40000 ALTER TABLE `cocinero` DISABLE KEYS */;
INSERT INTO `cocinero` (`especialidad`, `email`, `contraseña`, `nombre`, `apellidos`, `experiencia`, `ciudad`, `telefono`) VALUES
	('gambas', 'email2@gmail.com', 'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe', 'sevilla', 'Pedro', '123456789', 'sevilla', 'Romero'),
	('Jamon', 'email3@gmail.com', 'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 'Sevilla', 'Pepito', '123456789', 'Sevilla', 'Palotes'),
	('', 'email@gmail.com', 'e13efc991a9bf44bbb4da87cdbb725240184585ccaf270523170e008cf2a3b85f45f86c3da647f69780fb9e971caf5437b3d06d418355a68c9760c70a31d05c7', 'sevilla', 'Juan', '123456789', 'sevilla', 'Gomez');
/*!40000 ALTER TABLE `cocinero` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.cocinero_x_servicio: ~0 rows (aproximadamente)
DELETE FROM `cocinero_x_servicio`;
/*!40000 ALTER TABLE `cocinero_x_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `cocinero_x_servicio` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.empresa: ~0 rows (aproximadamente)
DELETE FROM `empresa`;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` (`cif`, `domicilio`, `nombre`, `telefono`, `ciudad`, `email`, `contraseña`, `apellidos`, `experiencia`) VALUES
	('email@gmail.com', '123456', 'Alvaro', 'Sevilla', '123456789', 'null', '37e7df39dd21d9aba5932cf39dec5223118c6500643e123c8040272129bc814a833d7fdeb3fd6950a736e1a5b4e1ab3ff7a66f179dd60f34b348fc4b852a157f', 'Perez', '123456789');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.empresa_x_servicio: ~0 rows (aproximadamente)
DELETE FROM `empresa_x_servicio`;
/*!40000 ALTER TABLE `empresa_x_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa_x_servicio` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.material: ~0 rows (aproximadamente)
DELETE FROM `material`;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.material_x_servicio: ~0 rows (aproximadamente)
DELETE FROM `material_x_servicio`;
/*!40000 ALTER TABLE `material_x_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `material_x_servicio` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.opinion: ~1 rows (aproximadamente)
DELETE FROM `opinion`;
/*!40000 ALTER TABLE `opinion` DISABLE KEYS */;
INSERT INTO `opinion` (`id_opinion`, `critica`, `puntuacion`) VALUES
	(1, 'Muy buena app', 10);
/*!40000 ALTER TABLE `opinion` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.servicio: ~0 rows (aproximadamente)
DELETE FROM `servicio`;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.tipo_material: ~2 rows (aproximadamente)
DELETE FROM `tipo_material`;
/*!40000 ALTER TABLE `tipo_material` DISABLE KEYS */;
INSERT INTO `tipo_material` (`nombre_tipo_material`, `cantidad`) VALUES
	('cuchara', 20),
	('tenedor', 20);
/*!40000 ALTER TABLE `tipo_material` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.tipo_servicio: ~2 rows (aproximadamente)
DELETE FROM `tipo_servicio`;
/*!40000 ALTER TABLE `tipo_servicio` DISABLE KEYS */;
INSERT INTO `tipo_servicio` (`nombre_tipo_servicio`, `calidad`) VALUES
	('catering', 100),
	('cocinado', 120);
/*!40000 ALTER TABLE `tipo_servicio` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
