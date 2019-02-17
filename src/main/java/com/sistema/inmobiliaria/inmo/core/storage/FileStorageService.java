package com.sistema.inmobiliaria.inmo.core.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author Ruben Guarachi
 */
public interface FileStorageService {

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

    boolean deleteFile(String fileName);

}
