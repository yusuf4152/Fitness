package com.coding.fitness.service;

import com.coding.fitness.config.BucketName;
import com.coding.fitness.dto.converter.GetHubExerciseDtoConverter;
import com.coding.fitness.dto.requests.CreateHubExerciseDto;
import com.coding.fitness.dto.responses.GetHubExerciseDto;
import com.coding.fitness.entity.HubExercise;
import com.coding.fitness.repository.HubExerciseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.apache.http.entity.ContentType.*;
import static org.apache.http.entity.ContentType.IMAGE_JPEG;

@Service
public class HubExerciseService {
    private final HubExerciseRepository hubExerciseRepository;
    private final GetHubExerciseDtoConverter getHubExerciseDtoConverter;
    private final FileService fileService;

    public HubExerciseService(HubExerciseRepository hubExerciseRepository,
                              GetHubExerciseDtoConverter getHubExerciseDtoConverter, FileService fileService) {
        this.hubExerciseRepository = hubExerciseRepository;
        this.getHubExerciseDtoConverter = getHubExerciseDtoConverter;
        this.fileService = fileService;
    }

    public GetHubExerciseDto createHubExercise(CreateHubExerciseDto createHubExerciseDto) {
        HubExercise hubExercise = new HubExercise();
        hubExercise.setName(createHubExerciseDto.getName());
        hubExercise.setDescription(createHubExerciseDto.getDescription());
        hubExercise.setSets(createHubExerciseDto.getSets());
        hubExercise.setSteps(createHubExerciseDto.getSteps());
        hubExercise.setType(createHubExerciseDto.getType());
        return getHubExerciseDtoConverter.convert(hubExerciseRepository.save(hubExercise));
    }

    public List<GetHubExerciseDto> getAllHubExercises() {
        return hubExerciseRepository.findAll()
                .stream()
                .map(getHubExerciseDtoConverter::convert).collect(Collectors.toList());
    }

    public HubExercise saveImage(long id, MultipartFile file) {
        //check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        //Check if the file is an image
        if (!Arrays.asList(IMAGE_PNG.getMimeType(),
                IMAGE_BMP.getMimeType(),
                IMAGE_GIF.getMimeType(),
                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("FIle uploaded is not an image");
        }
        //get file metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        //Save Image in S3 and then save Todo in the database
        String path = String.format("%s/%s", BucketName.TODO_IMAGE.getBucketName(), UUID.randomUUID());
        String fileName = String.format("%s", file.getOriginalFilename());
        try {
            fileService.upload(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }
        HubExercise hubExercise = getHubExercise(id);

        hubExercise.setImagePath(path);
        hubExercise.setImageFileName(fileName);
        hubExerciseRepository.save(hubExercise);
        return hubExercise;
    }

    private HubExercise getHubExercise(long id) {
        return hubExerciseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " " + "not found"));
    }

    public byte[] downloadImageByExerciseId(long id) {
        HubExercise hubExercise = getHubExercise(id);
        return fileService.download(hubExercise.getImagePath(), hubExercise.getImageFileName());
    }

}
