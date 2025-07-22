

# Ejmplos de metodos de clase `MaquinaController`




## 🧾 **Listado de Maquinas**

```java
List<Maquina> maquinas = Arrays.asList(
    new Maquina("Servidor1", "192.168.200.15", Arrays.asList(5, 10, 3)),        // subred: 15, riesgo: 
    new Maquina("Servidor1", "10.0.200.88", Arrays.asList(10, 2)),              // subred: 88, riesgo: 
    new Maquina("Alpha2", "192.168.100.8", Arrays.asList(25, 1, 3, 10)),        // subred: 8, riesgo: 
    new Maquina("Beta22", "10.0.250.100", Arrays.asList(5, 5, 5)),              // subred: 100, riesgo:
    new Maquina("Beta22", "172.16.250.101", Arrays.asList(10, 5)),              // subred: 101, riesgo:     
    new Maquina("Base de Datos 1", "10.0.50.99", Arrays.asList(5, 15, 20, 1)),  // subred: 99, riesgo: 
    new Maquina("ControlBackupX9", "172.16.90.5", Arrays.asList(25, 5, 10)),    // subred: 5, riesgo: 
    new Maquina("ControlBackupX9", "172.16.99.8", Arrays.asList(5, 10))         // subred: 8, riesgo: 
);
```

---

## 🔷 Método A: `filtrarPorSubred(maquinas, 100)`

Este método filtra las máquinas cuya subred sea menor a un umbral (ejemplo 50) y las devuelve en una pila en el orden en que aparecen en la lista original.

### 📥 Entrada:

Umbral: `100`

### ✅ Salida esperada (`Stack<Maquina>`):

Servidor1 -  192.168.200.15 (subred: 15)
Alpha2 -  192.168.100.8 (subred: 8)
ControlBackupX9 -  172.16.90.5 (subred: 5)
ControlBackupX9 -  172.16.99.8 (subred: 8)

---

## 🔷 Método B: `ordenarPorSubred(Stack)`

Este método ordena las máquinas por subred en orden ascendente. Si la rubred es igual validar el nombre orden ascendentite igual. En caso de que dos máquinas tengan el mismo nombre y subred, solo se conserva una (el `TreeSet` elimina duplicados bajo ese criterio).

### 📥 Entrada:

Stack con:

* Servidor1 - (15)
* ControlBackupX9 - (8)
* Alpha2 - (8)
* ControlBackupX9 - (8)
* ControlBackupX9 - (5)

### ✅ Salida esperada (`TreeSet<Maquina>`):

1. ControlBackupX9 (subred: 5)
2. Alpha2 (subred: 8)
3. ControlBackupX9 (subred: 8)
4. Servidor1 (subred: 15)

---

## 🔷 Método C: `agruparPorRiesgo(maquinas)`

Este método agrupa las máquinas en un `TreeMap` donde la clave es el riesgo calculado y el valor es una cola (`Queue`) con las máquinas que tienen ese riesgo. El mapa queda ordenado de menor a mayor riesgo.

### ✅ Salida esperada (`Map<Integer, Queue<Maquina>>`):

```text
75  → [Beta22, Beta22]
120 → [Servidor1, Servidor1]
210 → [Alpha2]
240 → [ControlBackupX9]
320 → [Base de Datos 1]
560 → [ControlBackupX9]p
```

---

## 🔷 Método D: `explotarGrupo(Map)`

Este método encuentra el grupo más numeroso (mayor cantidad de máquinas) y, en caso de empate, elige el que tenga mayor riesgo. Devuelve una pila con esas máquinas en orden invertido (LIFO).

### ✅ Salida esperada (`Stack<Maquina>`):

```text
[Servidor1, Servidor1]
```

---

## 📌 Resumen general de ejecución

| Método | Salida esperada                                                                  |
| ------ | -------------------------------------------------------------------------------- |
| A      | Stack: `[Beta22, Beta22, Servidor1, Servidor1]` (orden de entrada, subred > 100) |
| B      | TreeSet: `[Beta22, Servidor1]` (subred DESC, nombre ASC, sin duplicados)         |
| C      | Map: claves = riesgo, colas agrupadas (algunos con 2 elementos)                  |
| D      | Stack: `[Servidor1, Servidor1]` (grupo más grande con mayor riesgo)              |
