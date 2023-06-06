# Challenge ONE | Back End | Foro Alura

<p align="center" >
     <img width="200" height="200" src="https://user-images.githubusercontent.com/91544872/209678377-70b50b21-33de-424c-bed8-6a71ef3406ff.png">
</p>

## ¡Bienvenido al proyecto con las clases base del desafío Foro Alura con Java y Spring! 

## Tecnologías utilizadas
- [MySql](https://www.mysql.com/)
- [Java](https://www.java.com/en/)
- [Spring Security](https://start.spring.io/)
- [Token JWT](https://jwt.io/)

## Funcionalidades
Nuestra API se centra específicamente en los tópicos y permite a los usuarios realizar las siguientes acciones:

### Crear un nuevo tópico
La API cuenta con un endpoint para registrar nuevos tópicos y acepta solicitudes POST en la ruta `/topicos`. Los datos del tópico (título, mensaje, autor y curso) deben enviarse en el cuerpo de la solicitud en formato JSON.

**Reglas del negocio**
- Todos los campos son obligatorios.
- La API no permite registros duplicados que contengan el mismo título y mensaje.

### Mostrar todos los tópicos creados
La API tiene un endpoint para obtener la lista de todos los tópicos y acepta solicitudes GET en la ruta `/topicos`. Los datos del tópico (título, mensaje, fecha de creación, estatus, autor y curso) se devuelven en el cuerpo de la respuesta en formato JSON.

### Mostrar un tópico específico
La API cuenta con un endpoint para obtener un tópico específico y acepta solicitudes GET en la ruta `/topicos/{id}`. Los datos del tópico (título, mensaje, fecha de creación, estatus, autor y curso) se devuelven en el cuerpo de la respuesta en formato JSON.

### Actualizar un tópico
La API tiene un endpoint para actualizar tópicos existentes y acepta solicitudes PUT en la ruta `/topicos/{id}`.

**Observación**
- Se aplican las mismas reglas de negocio para la actualización de un tópico que para su registro.

### Eliminar un tópico
La API cuenta con un endpoint para eliminar tópicos y acepta solicitudes DELETE en la ruta `/topicos/{id}`.

---

💙 Alura Latam

[![img](https://camo.githubusercontent.com/c00f87aeebbec37f3ee0857cc4c20b21fefde8a96caf4744383ebfe44a47fe3f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d4c696e6b6564496e2d2532333030373742353f7374796c653d666f722d7468652d6261646765266c6f676f3d6c696e6b6564696e266c6f676f436f6c6f723d7768697465)](https://www.linkedin.com/company/alura-latam/mycompany/)

🧡 Oracle

[![img](https://camo.githubusercontent.com/c00f87aeebbec37f3ee0857cc4c20b21fefde8a96caf4744383ebfe44a47fe3f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d4c696e6b6564496e2d2532333030373742353f7374796c653d666f722d7468652d6261646765266c6f676f3d6c696e6b6564696e266c6f676f436f6c6f723d7768697465)](https://www.linkedin.com/company/oracle/)

<h3>Preview</h3>
[![Insomnia.jpg](https://i.postimg.cc/BbBmHChH/Insomnia.jpg)](https://postimg.cc/V059cXPk)
