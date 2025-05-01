
# Herokuapp TestNG Automation Suite

Este proyecto contiene un conjunto de pruebas automatizadas para la aplicación web [The Internet](https://the-internet.herokuapp.com/) utilizando **Selenium WebDriver** y **TestNG**.

## Tabla de Contenidos
- [Requisitos](#requisitos)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Configuración](#configuración)
- [Ejecución de Pruebas](#ejecución-de-pruebas)
- [Archivos Importantes](#archivos-importantes)
- [Contribuciones](#contribuciones)

## Requisitos

Antes de comenzar, asegúrate de tener los siguientes componentes instalados en tu máquina:

- **Java Development Kit (JDK)** 8 o superior.
- **Apache Maven** para la gestión de dependencias y construcción del proyecto.
- **Google Chrome** y la versión correspondiente de **ChromeDriver**.
- Un IDE como **IntelliJ IDEA** o **Visual Studio Code** para facilitar el desarrollo.

## Estructura del Proyecto

El proyecto sigue una estructura estándar para pruebas automatizadas con Selenium y TestNG:

```
QA-automation/
│
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   ├── com/
│       │   │   ├── advanced/
│       │   │   │   └── AdvancedTest.java
│       │   │   └── basic/
│       │   │       └── BasicTest.java
│       └── resources/
│
├── pom.xml
└── advancedtest.xml
```

### Descripción de Archivos

- **`AdvancedTest.java`**: Contiene pruebas avanzadas, como manejo de menús desplegables.
- **`BasicTest.java`**: Contiene pruebas básicas de interacción con la aplicación.
- **`advancedtest.xml`**: Archivo de configuración de TestNG para ejecutar pruebas específicas de `AdvancedTest.java`.
- **`pom.xml`**: Archivo de configuración de Maven para gestionar dependencias (Selenium, TestNG, SLF4J para logs, etc.).

## Configuración

Sigue estos pasos para configurar tu entorno y empezar con las pruebas automatizadas:

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd QA-automation
   ```

2. Instala las dependencias del proyecto usando Maven:
   ```bash
   mvn clean install
   ```

3. Asegúrate de que **ChromeDriver** esté disponible en tu **PATH** o especifica su ubicación en el código de las pruebas.

## Ejecución de Pruebas

### Ejecutar todas las pruebas

Para ejecutar todas las pruebas del proyecto, usa el siguiente comando:

```bash
mvn test
```

### Ejecutar pruebas específicas usando el archivo XML

Para ejecutar las pruebas definidas en un archivo XML de TestNG (por ejemplo, `advancedtest.xml`):

```bash
mvn test -DsuiteXmlFile=advancedtest.xml
```

### Ejecutar una clase de prueba específica

Si deseas ejecutar una clase de prueba específica, por ejemplo, `AdvancedTest`:

```bash
mvn test -Dtest=AdvancedTest
```

## Archivos Importantes

- **`advancedtest.xml`**: Archivo de configuración de TestNG que define las pruebas a ejecutar (en este caso, las de `AdvancedTest.java`).
- **`pom.xml`**: Archivo de configuración de Maven para gestionar las dependencias del proyecto, como:
  - **Selenium WebDriver**
  - **TestNG**
  - **SLF4J** (para logs)

## Contribuciones

Si deseas contribuir a este proyecto, sigue estos pasos:

1. Haz un **fork** del repositorio.
2. Crea una nueva rama para tu funcionalidad:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza tus cambios y realiza un **commit**.
4. Envía un **pull request** con tus cambios.

Gracias por tu interés en contribuir a este proyecto.