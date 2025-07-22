
# Objeto `Maquina`


* El **riesgo** se calcula como:
  👉 *suma de los códigos divisibles por 5* ✖️ *cantidad de **caracteres únicos** en el nombre (exceptuando espacios)*

* La **subred** se obtiene del cuarto octeto de la dirección IP (ej. `192.168.200.15` → `200`)

* Los **códigos** son una lista de enteros que pueden incluir números como `5`, `10`, `15`, etc.
* El **nombre** es una cadena de texto que puede contener letras, números y espacios.
---
## Ejemplos de Objetos `Maquina` con Riesgo y Subred como campos Calculados

### ✅ **Ejemplo 1**

```java
new Maquina("Servidor1", "192.168.200.15", Arrays.asList(5, 9, 3))
```

* **Subred**: `15` ← cuarto octeto de IP
* **Códigos divisibles por 3**: `9`, `3` → suma = `12`
* **Nombre**: `"Servidor1"`
* **Caracteres únicos**: `{'S','e','r','v','i','d','o','1'}` → 8
* **Riesgo**: `12 * 8 = 96`

---

### ✅ **Ejemplo 2**

```java
new Maquina("Base de Datos 1", "10.0.50.99", Arrays.asList(5, 15, 20, 1))
```

* **Subred**: `99`
* **Códigos divisibles por 3**: `15` → suma = `15`
* **Nombre**: `"Base de Datos 1"`
* **Caracteres únicos** (sin espacios):
  `{'B','a','s','e','d','t','o','1'}` → 8
* **Riesgo**: `15 * 8 = 120`

---

### ✅ **Ejemplo 3**

```java
new Maquina("Alpha2", "192.168.100.8", Arrays.asList(25, 1, 3, 10))
```

* **Subred**: `8`
* **Códigos divisibles por 3**: `3` → suma = `3`
* **Nombre**: `"Alpha2"`
* **Caracteres únicos**: `{'A','l','p','h','a','2'}` → 6
* **Riesgo**: `3 * 6 = 18`

---

### ✅ **Ejemplo 4**

```java
new Maquina("Beta22", "10.0.250.100", Arrays.asList(5, 5, 5))
```

* **Subred**: `100`
* **Códigos divisibles por 3**: `0 = 0`
* **Nombre**: `"Beta22"`
* **Caracteres únicos**: `{'B','e','t','a','2'}` → 5
* **Riesgo**: `0 * 5 = 0`


---

### ✅ **Ejemplo 5 (máximo riesgo por muchos caracteres únicos)**

```java
new Maquina("ControlBackupX9", "172.16.90.5", Arrays.asList(21, 5, 10))
```

* **Subred**: `5`
* **Suma de divisibles por 3**: `21`
* **Nombre**: `"ControlBackupX9"`
* **Caracteres únicos**:
  `{'C','o','n','t','r','l','B','a','c','k','u','p','X','9'}` → 14
* **Riesgo**: `21 * 14 = 294`

