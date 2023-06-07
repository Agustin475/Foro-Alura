Foro Alura Back End

<p align="center" >
     <img width="200" height="200" src="https://user-images.githubusercontent.com/91544872/209678377-70b50b21-33de-424c-bed8-6a71ef3406ff.png">
</p>

## ¡Bienvenido al proyecto Foro Alura con Java y Spring! 

## Tecnologías utilizadas
- [MySql](https://www.mysql.com/)
- [Java](https://www.java.com/en/)
- [Spring Security](https://start.spring.io/)
- [Token JWT](https://jwt.io/)

## Funcionalidades
Nuestra API se centra específicamente en los tópicos y permite a los usuarios realizar las siguientes acciones:

**Reglas del negocio**
- Todos los campos son obligatorios.
- La API no permite registros duplicados que contengan el mismo título y mensaje.

### Login Foro Alura
La API tiene un endpoint para logiarse al Foro Alura y acepta solicitudes POST en la ruta `/login`.
Los datos de jwToken se devuelven en el cuerpo de la respuesta en formato JSON.
[![1Login.jpg](https://i.postimg.cc/26Kkm4dd/1Login.jpg)](https://postimg.cc/r05XNRPz)

### Crear un nuevo tópico
La API cuenta con un endpoint para registrar nuevos tópicos y acepta solicitudes POST en la ruta `/topicos`. 
Los datos del tópico (título, mensaje, autor y curso) deben enviarse en el cuerpo de la solicitud en formato JSON.
[![2-Registrar-Topicos.jpg](https://i.postimg.cc/QMNKdJ7v/2-Registrar-Topicos.jpg)](https://postimg.cc/gx52MRNK)
[![2-Registrar-Topicos.jpg](https://i.postimg.cc/6QVrqvxD/2-Registrar-Topicos.jpg)](https://postimg.cc/qtRhZgRL)

### Mostrar todos los tópicos creados
La API tiene un endpoint para obtener la lista de todos los tópicos y acepta solicitudes GET en la ruta `/topicos`. 
Los datos del tópico (título, mensaje, fecha de creación, estatus, autor y curso) se devuelven en el cuerpo de la respuesta en formato JSON.
[![4-Listado-Topicos.jpg](https://i.postimg.cc/jqyxBJwf/4-Listado-Topicos.jpg)](https://postimg.cc/YjqBW0x2)

### Mostrar un tópico específico
La API cuenta con un endpoint para obtener un tópico específico y acepta solicitudes GET en la ruta `/topicos/{id}`. 
Los datos del tópico (título, mensaje, fecha de creación, estatus, autor y curso) se devuelven en el cuerpo de la respuesta en formato JSON.
[![3-Detalle-de-un-Topico.jpg](https://i.postimg.cc/mr6k2fBF/3-Detalle-de-un-Topico.jpg)](https://postimg.cc/5HLbnrHx)

### Actualizar un tópico
La API tiene un endpoint para actualizar tópicos existentes y acepta solicitudes PUT en la ruta `/topicos/{id}`.
[![5-Actualizar-Topico.jpg](https://i.postimg.cc/9f4Vb4Hr/5-Actualizar-Topico.jpg)](https://postimg.cc/p9tgXLTH)


### Eliminar un tópico
La API cuenta con un endpoint para eliminar tópicos y acepta solicitudes DELETE en la ruta `/topicos/{id}`.
[![6-Borrar-Topico.jpg](https://i.postimg.cc/NjnvKg2Y/6-Borrar-Topico.jpg)](https://postimg.cc/dhGxXc9S)

---

Si te gusto marca este proyecto con una ⭐

Autor:

🧡 <strong>Agustin Sanchez</strong></br>
<a href="https://www.linkedin.com/in/agustin-sanchez/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>

💙 Alura Latam

[![img](https://camo.githubusercontent.com/c00f87aeebbec37f3ee0857cc4c20b21fefde8a96caf4744383ebfe44a47fe3f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d4c696e6b6564496e2d2532333030373742353f7374796c653d666f722d7468652d6261646765266c6f676f3d6c696e6b6564696e266c6f676f436f6c6f723d7768697465)](https://www.linkedin.com/company/alura-latam/mycompany/)

🧡 Oracle

[![img](https://camo.githubusercontent.com/c00f87aeebbec37f3ee0857cc4c20b21fefde8a96caf4744383ebfe44a47fe3f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d4c696e6b6564496e2d2532333030373742353f7374796c653d666f722d7468652d6261646765266c6f676f3d6c696e6b6564696e266c6f676f436f6c6f723d7768697465)](https://www.linkedin.com/company/oracle/)










