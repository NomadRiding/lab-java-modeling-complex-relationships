package com.ironhack.modeling.respositoryTest;

import com.ironhack.modeling.repository.ChapterRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ChapterRepositoryTest {
    @Autowired
    ChapterRepository chapterRepository;

    Chapter chapter;

    @BeforeEach
    void setUp() {
        chapter = new Chapter(1234,"Chapter3","District10");
        chapterRepository.save(chapter);

    }
    @AfterEach
    void tearDown() {
        chapterRepository.deleteAll();
    }


    @Test
    public void findAll_chaptersPresent_chapterList() {
        Chapter newChapter = new Chapter(5678, "Chapter4", "District11");
        chapterRepository.save(newChapter);
        List<Chapter> chapterList = chapterRepository.findAll();
        assertEquals(2, chapterList.size());
    }

    @Test
    public void deleteById_validId_chapterDeleted() {
        chapterRepository.deleteById(1234);
        Optional<Chapter> foundChapter = chapterRepository.findById(1234);
        assertTrue(foundChapter.isEmpty());
    }


    @Test
    public void findById_invalidId_chapterNotPresent() {
        Optional<Chapter> chapterOptional = chapterRepository.findById(999);
        assertTrue(chapterOptional.isEmpty());
    }

}