# Aprende como configurar Maven Profile para diferentes entornos

El proyecto desarrollado permite las instrucciones necesarias sobre cómo configurar un perfil en Maven para diferentes entornos (desarrollo, prueba o producción). 

## Explicación del proyecto

Puedes ver a detalle el proyecto directamente desde mi canal de YouTube [https://youtu.be/HXGLOp617LQ](https://youtu.be/HXGLOp617LQ).


## Script de la base de datos

```
create database prod;
CREATE TABLE `prod`.`usuario` (
  `id_usuario` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_usuario`));
  INSERT INTO `prod`.`usuario` (`nombre`) VALUES ('HOLA PROD');


create database dev;
CREATE TABLE `dev`.`usuario` (
  `id_usuario` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_usuario`));
  INSERT INTO `dev`.`usuario` (`nombre`) VALUES ('HOLA DEV');
```
