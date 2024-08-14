package com.ironhack.modeling.respositoryTest;

import com.ironhack.modeling.model.Speaker;
import com.ironhack.modeling.repository.SpeakerRepository;
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
public class SpeakerRepositoryTest {

    @Autowired
    SpeakerRepository speakerRepository;

    Speaker speaker;

    @BeforeEach
    void setUp() {
        speaker = new Speaker(3904,"Bjorn");
        speakerRepository.save(speaker);

    }
    @AfterEach
    void tearDown() {
        speakerRepository.deleteAll();
    }


    @Test
    public void findAll_speakersPresent_speakerList() {
        Speaker newSpeaker = new Speaker(9099, "Helga" );
        speakerRepository.save(newSpeaker);
        List<Speaker> memberList = speakerRepository.findAll();
        assertEquals(2, memberList.size());
    }

    @Test
    public void deleteById_validId_speakerDeleted() {
        speakerRepository.deleteById(3234);
        Optional<Speaker> foundSpeaker = speakerRepository.findById(3234);
        assertTrue(foundSpeaker.isEmpty());
    }


    @Test
    public void findById_invalidId_speakerNotPresent() {
        Optional<Speaker> speakerOptional = speakerRepository.findById(203);
        assertTrue(speakerOptional.isEmpty());
    }

}