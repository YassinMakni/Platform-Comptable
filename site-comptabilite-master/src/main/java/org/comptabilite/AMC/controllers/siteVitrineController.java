package org.comptabilite.AMC.controllers;

import org.comptabilite.AMC.entities.Document;
import org.comptabilite.AMC.enums.TypeFolder;
import org.comptabilite.AMC.services.DocumentService;
import org.comptabilite.AMC.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/ressources")
public class siteVitrineController {
    @Autowired
    private DocumentService documentService ;

    @Autowired
    StorageService storageService;

    @GetMapping("/document/news/{type}")
    public List<Document> getDocumentNews(@PathVariable final TypeFolder type){
        return documentService.getDocumentNews(type) ;
    }
    @GetMapping("/document/{id}")
    public Document getDocument(@PathVariable final int id){
        Document document = documentService.getDocumentById(id) ;
        Resource file = documentService.loadFile(document.getName());
        return document ;
    }
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
