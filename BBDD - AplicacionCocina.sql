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
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.alimento_x_servicio: ~1 rows (aproximadamente)
DELETE FROM `alimento_x_servicio`;
/*!40000 ALTER TABLE `alimento_x_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `alimento_x_servicio` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.catador: ~2 rows (aproximadamente)
DELETE FROM `catador`;
/*!40000 ALTER TABLE `catador` DISABLE KEYS */;
/*!40000 ALTER TABLE `catador` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.catador_x_servicio: ~1 rows (aproximadamente)
DELETE FROM `catador_x_servicio`;
/*!40000 ALTER TABLE `catador_x_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `catador_x_servicio` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.cocinero: ~0 rows (aproximadamente)
DELETE FROM `cocinero`;
/*!40000 ALTER TABLE `cocinero` DISABLE KEYS */;
/*!40000 ALTER TABLE `cocinero` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.cocinero_x_servicio: ~0 rows (aproximadamente)
DELETE FROM `cocinero_x_servicio`;
/*!40000 ALTER TABLE `cocinero_x_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `cocinero_x_servicio` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.empresa: ~1 rows (aproximadamente)
DELETE FROM `empresa`;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.empresa_x_servicio: ~0 rows (aproximadamente)
DELETE FROM `empresa_x_servicio`;
/*!40000 ALTER TABLE `empresa_x_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa_x_servicio` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.material: ~1 rows (aproximadamente)
DELETE FROM `material`;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.material_x_servicio: ~1 rows (aproximadamente)
DELETE FROM `material_x_servicio`;
/*!40000 ALTER TABLE `material_x_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `material_x_servicio` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.opinion: ~2 rows (aproximadamente)
DELETE FROM `opinion`;
/*!40000 ALTER TABLE `opinion` DISABLE KEYS */;
/*!40000 ALTER TABLE `opinion` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.servicio: ~1 rows (aproximadamente)
DELETE FROM `servicio`;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.tipo_material: ~1 rows (aproximadamente)
DELETE FROM `tipo_material`;
/*!40000 ALTER TABLE `tipo_material` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_material` ENABLE KEYS */;

-- Volcando datos para la tabla appcocina.tipo_servicio: ~1 rows (aproximadamente)
DELETE FROM `tipo_servicio`;
/*!40000 ALTER TABLE `tipo_servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_servicio` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
