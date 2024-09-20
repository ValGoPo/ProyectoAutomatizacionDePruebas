# Compras en linea: Tests con selenium y Java

Este proyecto utiliza Selenium para automatizar Test Case de la pagina https://www.saucedemo.com/
## Herramientas

- [AQUA IDE]([https://pip.pypa.io/en/stable/](https://www.jetbrains.com/es-es/aqua/))
- Complementos (Estos de descargan automaticamente a la hora te utilizar el entorno)

## Proceso para ejecutar mi proyecto

### Paso 1: Unzip el archivo descargado del repositorio.

### Paso 2: Abrir AQUA IDE

### Paso 3: Importar el proyecto

-Ir al menu de la izquierda de las 3 rayas.

-Seleccionar Open y buscar el archivo descomprimido

-Cargar la carpeta completa

### Paso 4: Ejecutar los scripts
-Dentro del proyecto en la carpeta: src/java/com/ se encuentran los scripts necesarios para hacer todas las pruebas

### Paso 5: Herramienta de reportes Allure
-Instalar Allure en Windows:

--Abrir PowerShell y ejecutar este codigo
```bash
Set-ExecutionPolicy RemoteSigned -scope CurrentUser
irm get.scoop.sh | iex
```

-Instala Allure:

--Abrir PowerShell y ejecutar este codigo
```bash
scoop install allure
```

-Instala Allure:

--Abrir PowerShell y ejecutar este codigo
```bash
scoop install allure
```
### Paso 6: Generar reportes en AQUA
-Ya instalado Allure se puede generar reportes con la terminal de AQUA con el siguiente comando:
```bash
allure serve allure-results
```

-NOTA:Dentro de cada script se encuentra comentado cada TestCase que se debia abarcar segun mi Plan de pruebas.

# Clonar repositorio
-Se puede incluso clonar el repositorio en AQUA con el link proporcionado por GitHub.
