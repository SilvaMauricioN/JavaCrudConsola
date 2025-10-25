# 🎨 CRUD de Obras de Arte y Autores — Java por Consola

Este proyecto implementa un sistema **CRUD (Crear, Leer, Actualizar y Eliminar)** por consola en **Java 17**, que permite gestionar **autores de arte** y sus **obras asociadas**.  
Fue desarrollado como práctica de **programación orientada a objetos (POO)**, control de relaciones entre entidades y validación de dependencias.

---

## 🧩 Descripción General

El sistema permite administrar dos entidades principales:

- **AutorPrincipal:** contiene la información personal y artística del autor (nombre, fecha de nacimiento, nacionalidad, etc.).
- **ObraArte:** representa una obra creada por un autor, incluyendo título, materiales, técnicas y el medio físico en que fue realizada.

Cada obra está **asociada a un autor** mediante su identificador (`idAutorPrincipal`), asegurando una relación uno-a-muchos (un autor puede tener varias obras).

---

## ⚙️ Funcionalidades

### 👤 Autores (AutorPrincipal)

- Crear un nuevo autor.
- Listar todos los autores registrados.
- Actualizar la información de un autor existente.
- Eliminar un autor **solo si no tiene obras asociadas**.

### 🖌️ Obras de Arte (ObraArte)

- Crear una nueva obra (solo si el autor existe).
- Listar todas las obras registradas.
- Actualizar los datos de una obra existente.
- Eliminar una obra de arte.

---

## 🔄 Reglas de Negocio

- No se puede **eliminar un autor** si tiene obras registradas.
- No se puede **crear o actualizar una obra** con un autor inexistente.
- Los identificadores (`idAutorPrincipal` y `idObraArte`) se manejan de forma interna o manual según la implementación.
- Se valida que los campos obligatorios no estén vacíos.

---

## 🧱 Estructura del Proyecto
