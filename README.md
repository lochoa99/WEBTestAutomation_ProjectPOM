# WEBTestAutomation_ProjectPOM

# 🧪 SauceDemo UI Automation Framework (Selenium + POM)

Este proyecto es una suite de pruebas automatizadas para la plataforma [SauceDemo](https://www.saucedemo.com/), desarrollada en **Java** utilizando **Selenium WebDriver** y el patrón de diseño **Page Object Model (POM)**.

## 🚀 Características del Proyecto
* **Patrón de Diseño:** Page Object Model (POM) con **PageFactory** para una mejor mantenibilidad.
* **Base Pages & Tests:** Implementación de herencia para reutilizar lógica de configuración y manejo de drivers.
* **Pruebas Independientes:** Cada test es autocontenido y maneja sus propias precondiciones mediante anotaciones `@BeforeMethod`.
* **CI/CD Integration:** Configurado con **GitHub Actions** para ejecución automática en cada `push` (Modo Headless).

## 🛠️ Stack Tecnológico
* **Lenguaje:** Java 8 / 11
* **Framework de Pruebas:** TestNG
* **Automatización Web:** Selenium WebDriver (v4.13.0+)
* **Gestor de Dependencias:** Maven
* **Navegador:** Google Chrome

## 📂 Estructura del Proyecto
```text
src/test/java/
├── base/           # Configuración del Driver y clases padre
├── pages/          # Localizadores (@FindBy) y métodos de cada página
└── tests/          # Escenarios de prueba (Purchase, Remove, Logout)
