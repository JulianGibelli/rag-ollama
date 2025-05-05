package com.example.rag_ollama.services;


import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngestionService implements CommandLineRunner {

    @Value("classpath:/docs/spboot.pdf")
    private Resource pdf;

    private final VectorStore vectorStore;

    @Autowired
    public IngestionService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @Override
    public void run(String... args) throws Exception {

        TikaDocumentReader tikaDocumentReader = new TikaDocumentReader(pdf);

        TextSplitter textSplitter = new TokenTextSplitter();

        List<Document> documents = textSplitter.split(tikaDocumentReader.read());

        vectorStore.add(documents);

    }
}
