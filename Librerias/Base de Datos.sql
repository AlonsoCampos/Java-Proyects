
DROP SCHEMA IF EXISTS `global` ;
CREATE SCHEMA IF NOT EXISTS `global` DEFAULT CHARACTER SET latin1 ;
USE `global` ;

-- -----------------------------------------------------
-- Table `global`.`SUCURSALES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`SUCURSALES` (
  `claveSucursal` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(30) NOT NULL ,
  `descripcion` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`claveSucursal`) ,
  UNIQUE INDEX `claveSucursal_UNIQUE` (`claveSucursal` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`USUARIOS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`USUARIOS` (
  `clave` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `tipo` ENUM('Administrador','Cajero','Contador') NOT NULL ,
  `preguntaSeguridad` VARCHAR(45) NOT NULL ,
  `respuesta` VARCHAR(45) NOT NULL ,
  `sucursal` INT NOT NULL ,
  PRIMARY KEY (`clave`) ,
  INDEX `fk_Usuarios_Sucursales1_idx` (`sucursal` ASC) ,
  UNIQUE INDEX `clave_UNIQUE` (`clave` ASC) ,
  CONSTRAINT `fk_Usuarios_Sucursales1`
    FOREIGN KEY (`sucursal` )
    REFERENCES `global`.`SUCURSALES` (`claveSucursal` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`CODIGOSPOSTALES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`CODIGOSPOSTALES` (
  `claveCodigoPostal` INT NOT NULL AUTO_INCREMENT ,
  `codigoPostal` VARCHAR(5) NOT NULL ,
  `descripcion` VARCHAR(50) NULL ,
  PRIMARY KEY (`claveCodigoPostal`) ,
  UNIQUE INDEX `claveCodigoPostal_UNIQUE` (`claveCodigoPostal` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`ESTADOS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`ESTADOS` (
  `claveEstado` INT NOT NULL AUTO_INCREMENT ,
  `estado` VARCHAR(20) NOT NULL ,
  `descripcion` VARCHAR(50) NULL ,
  PRIMARY KEY (`claveEstado`) ,
  UNIQUE INDEX `claveEstado_UNIQUE` (`claveEstado` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`MUNICIPIOS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`MUNICIPIOS` (
  `claveMunicipio` INT NOT NULL AUTO_INCREMENT ,
  `municipio` VARCHAR(30) NOT NULL ,
  `descripcion` VARCHAR(50) NULL ,
  `codigoPostal` INT NULL ,
  `estado` INT NOT NULL ,
  PRIMARY KEY (`claveMunicipio`) ,
  INDEX `fk_Municipios_CodigosPostales1_idx` (`codigoPostal` ASC) ,
  UNIQUE INDEX `claveMunicipio_UNIQUE` (`claveMunicipio` ASC) ,
  INDEX `fk_MUNICIPIOS_ESTADOS1_idx` (`estado` ASC) ,
  CONSTRAINT `fk_Municipios_CodigosPostales1`
    FOREIGN KEY (`codigoPostal` )
    REFERENCES `global`.`CODIGOSPOSTALES` (`claveCodigoPostal` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_MUNICIPIOS_ESTADOS1`
    FOREIGN KEY (`estado` )
    REFERENCES `global`.`ESTADOS` (`claveEstado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`DOMICILIOS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`DOMICILIOS` (
  `claveDomicilio` INT NOT NULL AUTO_INCREMENT ,
  `domicilio` VARCHAR(50) NOT NULL ,
  `numeroInterno` VARCHAR(3) NOT NULL ,
  `numeroExterno` VARCHAR(3) NOT NULL ,
  `municipio` INT NOT NULL ,
  PRIMARY KEY (`claveDomicilio`) ,
  INDEX `fk_Domicilio_Municipios1_idx` (`municipio` ASC) ,
  UNIQUE INDEX `claveDomicilio_UNIQUE` (`claveDomicilio` ASC) ,
  CONSTRAINT `fk_Domicilio_Municipios1`
    FOREIGN KEY (`municipio` )
    REFERENCES `global`.`MUNICIPIOS` (`claveMunicipio` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`PERSONAS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`PERSONAS` (
  `idPersona` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `apellidoPaterno` VARCHAR(45) NOT NULL ,
  `apellidoMaterno` VARCHAR(45) NOT NULL ,
  `telefono` VARCHAR(12) NULL ,
  `domicilio` INT NULL ,
  PRIMARY KEY (`idPersona`) ,
  INDEX `fk_Personas_Direcciones_idx` (`domicilio` ASC) ,
  UNIQUE INDEX `idPersona_UNIQUE` (`idPersona` ASC) ,
  CONSTRAINT `fk_Personas_Direcciones`
    FOREIGN KEY (`domicilio` )
    REFERENCES `global`.`DOMICILIOS` (`claveDomicilio` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`CLIENTES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`CLIENTES` (
  `claveCliente` INT NOT NULL AUTO_INCREMENT ,
  `fechaRegistro` DATETIME NOT NULL ,
  `activo` BIT NOT NULL ,
  `tipoCliente` BIT NOT NULL ,
  `persona` INT NULL ,
  PRIMARY KEY (`claveCliente`) ,
  INDEX `fk_Clientes_Personas_idx` (`persona` ASC) ,
  UNIQUE INDEX `claveCliente_UNIQUE` (`claveCliente` ASC) ,
  CONSTRAINT `fk_Clientes_Personas`
    FOREIGN KEY (`persona` )
    REFERENCES `global`.`PERSONAS` (`idPersona` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`HISTORIALES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`HISTORIALES` (
  `claveHistorial` INT NOT NULL AUTO_INCREMENT ,
  `ultimaCompra` DATE NOT NULL ,
  `montoTotalUltimaCompra` FLOAT NOT NULL ,
  `total` FLOAT NOT NULL ,
  `cliente` INT NOT NULL ,
  PRIMARY KEY (`claveHistorial`) ,
  INDEX `fk_Historial_Clientes_idx` (`cliente` ASC) ,
  UNIQUE INDEX `claveHistorial_UNIQUE` (`claveHistorial` ASC) ,
  CONSTRAINT `fk_Historial_Clientes`
    FOREIGN KEY (`cliente` )
    REFERENCES `global`.`CLIENTES` (`claveCliente` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`DIRECCIONES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`DIRECCIONES` (
  `claveDireccion` INT NOT NULL AUTO_INCREMENT ,
  `calle` VARCHAR(50) NOT NULL ,
  `numeroInterno` VARCHAR(4) NOT NULL ,
  `numeroExterno` VARCHAR(4) NOT NULL ,
  `estado` INT NOT NULL ,
  PRIMARY KEY (`claveDireccion`) ,
  UNIQUE INDEX `claveDireccion_UNIQUE` (`claveDireccion` ASC) ,
  INDEX `fk_DIRECCIONES_ESTADOS1_idx` (`estado` ASC) ,
  CONSTRAINT `fk_DIRECCIONES_ESTADOS1`
    FOREIGN KEY (`estado` )
    REFERENCES `global`.`ESTADOS` (`claveEstado` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`EMPRESASPROVEEDORAS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`EMPRESASPROVEEDORAS` (
  `claveEmpresa` INT NOT NULL AUTO_INCREMENT ,
  `RFC` VARCHAR(12) NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  `razonSocial` VARCHAR(45) NOT NULL ,
  `fechaRegistro` DATE NOT NULL ,
  `activo` BIT NOT NULL ,
  `telefono` VARCHAR(12) NULL ,
  `direccion` INT NOT NULL ,
  PRIMARY KEY (`claveEmpresa`) ,
  INDEX `fk_EMPRESAS_DIRECCIONES1_idx` (`direccion` ASC) ,
  UNIQUE INDEX `claveEmpresa_UNIQUE` (`claveEmpresa` ASC) ,
  CONSTRAINT `fk_EMPRESAS_DIRECCIONES1`
    FOREIGN KEY (`direccion` )
    REFERENCES `global`.`DIRECCIONES` (`claveDireccion` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`DESCUENTOS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`DESCUENTOS` (
  `claveDescuento` INT NOT NULL AUTO_INCREMENT ,
  `descuento` FLOAT NOT NULL ,
  `descripcion` VARCHAR(20) NULL ,
  PRIMARY KEY (`claveDescuento`) ,
  UNIQUE INDEX `claveDescuento_UNIQUE` (`claveDescuento` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`FORMASPAGOS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`FORMASPAGOS` (
  `claveFormasPagos` INT NOT NULL AUTO_INCREMENT ,
  `formaPago` VARCHAR(25) NOT NULL ,
  `descripcion` VARCHAR(30) NULL ,
  PRIMARY KEY (`claveFormasPagos`) ,
  UNIQUE INDEX `claveFormasPagos_UNIQUE` (`claveFormasPagos` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`COMPRASCLIENTES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`COMPRASCLIENTES` (
  `claveCompraCliente` INT NOT NULL AUTO_INCREMENT ,
  `fechaCompra` DATE NOT NULL ,
  `subtotal` FLOAT NOT NULL ,
  `total` FLOAT NOT NULL ,
  `historial` INT NOT NULL ,
  `descuento` INT NOT NULL ,
  `formaPago` INT NOT NULL ,
  PRIMARY KEY (`claveCompraCliente`) ,
  INDEX `fk_VENTAS_Historial_idx` (`historial` ASC) ,
  INDEX `fk_VENTAS_DESCUENTOS1_idx` (`descuento` ASC) ,
  UNIQUE INDEX `claveVenta_UNIQUE` (`claveCompraCliente` ASC) ,
  INDEX `fk_COMPRASCLIENTES_FORMASPAGOS1_idx` (`formaPago` ASC) ,
  CONSTRAINT `fk_VENTAS_Historial`
    FOREIGN KEY (`historial` )
    REFERENCES `global`.`HISTORIALES` (`claveHistorial` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_VENTAS_DESCUENTOS1`
    FOREIGN KEY (`descuento` )
    REFERENCES `global`.`DESCUENTOS` (`claveDescuento` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_COMPRASCLIENTES_FORMASPAGOS1`
    FOREIGN KEY (`formaPago` )
    REFERENCES `global`.`FORMASPAGOS` (`claveFormasPagos` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`CALIDADES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`CALIDADES` (
  `claveCalidad` INT NOT NULL AUTO_INCREMENT ,
  `calidad` VARCHAR(20) NOT NULL ,
  `descripcion` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`claveCalidad`) ,
  UNIQUE INDEX `claveCalidad_UNIQUE` (`claveCalidad` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`CATEGORIAS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`CATEGORIAS` (
  `claveCategoria` INT NOT NULL AUTO_INCREMENT ,
  `categoria` VARCHAR(20) NOT NULL ,
  `descripcion` VARCHAR(25) NULL ,
  PRIMARY KEY (`claveCategoria`) ,
  UNIQUE INDEX `claveCategoria_UNIQUE` (`claveCategoria` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`MARCAS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`MARCAS` (
  `claveMarca` INT NOT NULL AUTO_INCREMENT ,
  `marca` VARCHAR(20) NOT NULL ,
  `descripcion` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`claveMarca`) ,
  UNIQUE INDEX `claveMarca_UNIQUE` (`claveMarca` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`PRODUCTOS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`PRODUCTOS` (
  `claveProducto` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `imagen` TEXT NULL ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`claveProducto`) ,
  UNIQUE INDEX `claveProducto_UNIQUE` (`claveProducto` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`UNIDADESMEDICIONES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`UNIDADESMEDICIONES` (
  `claveUnidadMedicion` INT NOT NULL AUTO_INCREMENT ,
  `unidadMedicion` VARCHAR(4) NOT NULL ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`claveUnidadMedicion`) ,
  UNIQUE INDEX `claveUnidadMedicion_UNIQUE` (`claveUnidadMedicion` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`DETALLESPRODUCTOS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`DETALLESPRODUCTOS` (
  `claveProducto` INT NOT NULL AUTO_INCREMENT ,
  `precioUnitario` FLOAT NOT NULL ,
  `fechaRegistro` DATE NOT NULL ,
  `existencias` INT NOT NULL ,
  `activo` BIT NOT NULL ,
  `producto` INT NOT NULL ,
  `calidad` INT NOT NULL ,
  `categorias` INT NOT NULL ,
  `marca` INT NOT NULL ,
  `unidadMedicion` INT NOT NULL ,
  `empresa` INT NOT NULL ,
  `sucursal` INT NOT NULL ,
  PRIMARY KEY (`claveProducto`) ,
  INDEX `fk_Productos_Calidades_idx` (`calidad` ASC) ,
  INDEX `fk_Productos_CLASIFICACIONES_idx` (`categorias` ASC) ,
  INDEX `fk_Productos_MARCAS_idx` (`marca` ASC) ,
  UNIQUE INDEX `claveProducto_UNIQUE` (`claveProducto` ASC) ,
  INDEX `fk_PRODUCTOS_PRODUCTO1_idx` (`producto` ASC) ,
  INDEX `fk_DETALLESPRODUCTOS_UNIDADESMEDICIONES1_idx` (`unidadMedicion` ASC) ,
  INDEX `fk_DETALLESPRODUCTOS_EMPRESASPROVEEDORAS1_idx` (`empresa` ASC) ,
  INDEX `fk_DETALLESPRODUCTOS_SUCURSALES1_idx` (`sucursal` ASC) ,
  CONSTRAINT `fk_Productos_Calidades`
    FOREIGN KEY (`calidad` )
    REFERENCES `global`.`CALIDADES` (`claveCalidad` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Productos_CLASIFICACIONES`
    FOREIGN KEY (`categorias` )
    REFERENCES `global`.`CATEGORIAS` (`claveCategoria` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Productos_MARCAS`
    FOREIGN KEY (`marca` )
    REFERENCES `global`.`MARCAS` (`claveMarca` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PRODUCTOS_PRODUCTO1`
    FOREIGN KEY (`producto` )
    REFERENCES `global`.`PRODUCTOS` (`claveProducto` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_DETALLESPRODUCTOS_UNIDADESMEDICIONES1`
    FOREIGN KEY (`unidadMedicion` )
    REFERENCES `global`.`UNIDADESMEDICIONES` (`claveUnidadMedicion` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_DETALLESPRODUCTOS_EMPRESASPROVEEDORAS1`
    FOREIGN KEY (`empresa` )
    REFERENCES `global`.`EMPRESASPROVEEDORAS` (`claveEmpresa` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_DETALLESPRODUCTOS_SUCURSALES1`
    FOREIGN KEY (`sucursal` )
    REFERENCES `global`.`SUCURSALES` (`claveSucursal` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`DETALLESCOMPRAS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`DETALLESCOMPRAS` (
  `compraCliente` INT NOT NULL ,
  `producto` INT NOT NULL ,
  `cantidad` INT NOT NULL ,
  PRIMARY KEY (`compraCliente`, `producto`) ,
  INDEX `fk_Productos_has_VENTAS_VENTAS_idx` (`compraCliente` ASC) ,
  INDEX `fk_DETALLESCOMPRAS_PRODUCTOS1_idx` (`producto` ASC) ,
  CONSTRAINT `fk_Productos_has_VENTAS_VENTAS`
    FOREIGN KEY (`compraCliente` )
    REFERENCES `global`.`COMPRASCLIENTES` (`claveCompraCliente` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_DETALLESCOMPRAS_PRODUCTOS1`
    FOREIGN KEY (`producto` )
    REFERENCES `global`.`PRODUCTOS` (`claveProducto` )
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `global`.`FACTURAS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`FACTURAS` (
  `claveFactura` INT NOT NULL AUTO_INCREMENT ,
  `fechaFactura` DATETIME NOT NULL ,
  `historial` INT NOT NULL ,
  `venta` INT NOT NULL ,
  PRIMARY KEY (`claveFactura`) ,
  UNIQUE INDEX `claveFactura_UNIQUE` (`claveFactura` ASC) ,
  INDEX `fk_FACTURAS_HISTORIAL1_idx` (`historial` ASC) ,
  INDEX `fk_FACTURAS_VENTAS1_idx` (`venta` ASC) ,
  CONSTRAINT `fk_FACTURAS_HISTORIAL1`
    FOREIGN KEY (`historial` )
    REFERENCES `global`.`HISTORIALES` (`claveHistorial` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_FACTURAS_VENTAS1`
    FOREIGN KEY (`venta` )
    REFERENCES `global`.`COMPRASCLIENTES` (`claveCompraCliente` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`CONTACTOS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`CONTACTOS` (
  `claveContacto` INT NOT NULL AUTO_INCREMENT ,
  `fechaRegistro` DATE NOT NULL ,
  `activo` BIT NOT NULL ,
  `telefono` VARCHAR(12) NULL ,
  `empresa` INT NOT NULL ,
  `persona` INT NOT NULL ,
  PRIMARY KEY (`claveContacto`) ,
  INDEX `fk_CONTACTOS_EMPRESASPROVEEDORAS1` (`empresa` ASC) ,
  INDEX `fk_CONTACTOS_Persona1` (`persona` ASC) ,
  UNIQUE INDEX `claveContacto_UNIQUE` (`claveContacto` ASC) ,
  CONSTRAINT `fk_CONTACTOS_EMPRESASPROVEEDORAS1`
    FOREIGN KEY (`empresa` )
    REFERENCES `global`.`EMPRESASPROVEEDORAS` (`claveEmpresa` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_CONTACTOS_Persona1`
    FOREIGN KEY (`persona` )
    REFERENCES `global`.`PERSONAS` (`idPersona` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `global`.`PRESUPUESTOS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `global`.`PRESUPUESTOS` (
  `clave` INT NOT NULL AUTO_INCREMENT ,
  `fechaPresupuesto` DATE NOT NULL ,
  `montoTotal` FLOAT NOT NULL ,
  `producto` INT NOT NULL ,
  `cliente` INT NOT NULL ,
  PRIMARY KEY (`clave`) ,
  INDEX `fk_PRESUPUESTOS_PRODUCTOS1_idx` (`producto` ASC) ,
  INDEX `fk_PRESUPUESTOS_CLIENTES1_idx` (`cliente` ASC) ,
  UNIQUE INDEX `clave_UNIQUE` (`clave` ASC) ,
  CONSTRAINT `fk_PRESUPUESTOS_PRODUCTOS1`
    FOREIGN KEY (`producto` )
    REFERENCES `global`.`PRODUCTOS` (`claveProducto` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PRESUPUESTOS_CLIENTES1`
    FOREIGN KEY (`cliente` )
    REFERENCES `global`.`CLIENTES` (`claveCliente` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

USE `global` ;
