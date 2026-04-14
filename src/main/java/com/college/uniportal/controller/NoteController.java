package com.college.uniportal.controller;

import com.college.uniportal.model.Note;
import com.college.uniportal.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*")   // ✅ FIXED CORS
public class NoteController {

    @Autowired
    private NoteRepository repo;

    // ✅ GET all notes
    @GetMapping
    public List<Note> getAll() {
        return repo.findAll();
    }

    // ✅ ADD NOTE WITH FILE
    @PostMapping
    public Note addNote(
            @RequestParam("title") String title,
            @RequestParam("date") String date,
            @RequestParam(value = "file", required = false) MultipartFile file
    ) throws Exception {

        String uploadDir = "uploads/";

        // ✅ Create folder if not exists
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        Note n = new Note();
        n.setTitle(title);
        n.setDate(date);

        // ✅ Save file only if present
        if (file != null && !file.isEmpty()) {

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            Path path = Paths.get(uploadDir + fileName);
            Files.write(path, file.getBytes());

            n.setFileName(fileName);
        }

        return repo.save(n);
    }

    // ✅ DOWNLOAD FILE
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws Exception {

        Note n = repo.findById(id).orElseThrow();

        Path path = Paths.get("uploads/" + n.getFileName());

        Resource resource = new UrlResource(path.toUri());

        // ✅ Detect file type dynamically
        String contentType = Files.probeContentType(path);
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + n.getFileName() + "\"")
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }

    // ✅ DELETE NOTE + FILE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {

        Note n = repo.findById(id).orElseThrow();

        // delete file from folder
        if (n.getFileName() != null) {
            Path path = Paths.get("uploads/" + n.getFileName());
            Files.deleteIfExists(path);
        }

        // delete from DB
        repo.deleteById(id);
    }
}