package com.jlv.petstore.services;


import com.jlv.petstore.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

    private long existingId;

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;

        //configure mock fom delete exists
        Mockito.doNothing().when(repository).deleteById(existingId);
        Mockito.when(repository.existsById(existingId)).thenReturn(true);
    }

    @Test
    public void testDeleteShouldDoNothingWhenIdExists() {

        Assertions.assertDoesNotThrow(() -> {
            service.delete(existingId);
        });

        Mockito.verify(repository, Mockito.times(1)).existsById(existingId);
        Mockito.verify(repository, Mockito.times(1)).deleteById(existingId);
    }
}
