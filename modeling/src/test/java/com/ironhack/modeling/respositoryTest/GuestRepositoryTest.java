package com.ironhack.modeling.respositoryTest;

import com.ironhack.modeling.model.Guest;
import com.ironhack.modeling.repository.GuestRepository;
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
public class GuestRepositoryTest {


    @Autowired
    GuestRepository guestRepository;

    Guest guest;

    @BeforeEach
    void setUp() {
        guest = new Guest(50949,"Fatima");
        guestRepository.save(guest);

    }
    @AfterEach
    void tearDown() {
        guestRepository.deleteAll();
    }


    @Test
    public void findAll_guestPresent_guestList() {
        Guest newGuest = new Guest(45902, "Jeremy");
        guestRepository.save(newGuest);
        List<Guest> guestList = guestRepository.findAll();
        assertEquals(2, guestList.size());
    }

    @Test
    public void deleteById_validId_guestDeleted() {
        guestRepository.deleteById(14509);
        Optional<Guest> foundGuest = guestRepository.findById(14509);
        assertTrue(foundGuest.isEmpty());
    }


    @Test
    public void findById_invalidId_guestNotPresent() {
        Optional<Guest> guestOptional = guestRepository.findById(56900);
        assertTrue(guestOptional.isEmpty());
    }

}