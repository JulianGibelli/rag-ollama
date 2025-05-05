# 📄 RAG con Spring Boot: PDF + PGVector + Ollama

Es una POC en Java con Spring Boot que permite:

- Cargar un PDF local.
- Dividir el contenido en *chunks* usando `TikaDocumentReader`.
- Convertir los chunks a vectores con embeddings.
- Guardarlos en una base de datos vectorial (PostgreSQL + PGVector).
- Recuperar contexto relevante a partir de una consulta.
- Usar Ollama para generar respuestas con contexto (*Retrieval-Augmented Generation*).
- Ollama esta debe correr localemente o en su defecto modificar el compose, para que descargue la imagen.

---

## ⚙️ Tecnologías utilizadas

- **Java 21+**
- **Spring Boot 3+**
- **Spring AI**
- **PGVector** (extensión para PostgreSQL)
- **Ollama**
- **Tika PDF reader**
- **Maven**
- **Docker**

---

## 🚀 Ejecución

1. Clonar el repositorio
2. Ejecutar en segundo plano Ollama 
3. Ejecutar la aplicacion levanta el compose.yaml (daemon de docker debe estar corriendo)

```
curl --location 'localhost:8080/api/chat' \
--header 'Content-Type: application/json' \
--data '<consulta aca>'
```

---
## 📄 Example
![postman](/postman.png)

