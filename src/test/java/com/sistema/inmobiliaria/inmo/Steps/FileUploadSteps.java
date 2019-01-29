package com.sistema.inmobiliaria.inmo.Steps;

import com.sistema.inmobiliaria.inmo.core.file.FileStorageService;
import com.sistema.inmobiliaria.inmo.core.file.StorageFileNotFoundException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.stream.Collectors;

public class FileUploadSteps extends StepsRestBaseIT {

    @Autowired
    private FileStorageService service;

    @Given("the service uploads a file")
    public void theServiceUploadsFile() {
        String filename = "temp-file.txt";
        MultipartFile multipartFile = new MockMultipartFile("temp-file", filename, "text/plain", "some data".getBytes());
        service.store(multipartFile);
        cucumberContext.setFileName(filename);
    }

    @Then("the file should be retrieved")
    public void theServiceShouldRetrieveFile() {
        Resource file = service.loadAsResource(cucumberContext.getFileName());
        assert file.exists();
        assert Objects.equals(file.getFilename(), cucumberContext.getFileName());
    }

    @Then("the file can be deleted")
    @Test(expected = StorageFileNotFoundException.class)
    public void theServiceShouldDeleteFile() {
        service.deleteAll();
        assert service.loadAll().collect(Collectors.toList()).isEmpty();
    }
}
