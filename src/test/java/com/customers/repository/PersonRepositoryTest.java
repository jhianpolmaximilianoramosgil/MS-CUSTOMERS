package com.customers.repository;

import com.customers.model.Person;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("PERSON")
class PersonRepositoryTest {

    @Mock
    private PersonRepository personRepository;

    Person person = new Person();

    Flux<Person> list;

    @BeforeAll
    void init() {
        System.out.println("START OF TESTS");
    }

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        person.setId("6428cfa73c4a07682cac5fa0");
        person.setName("Jhianpol Maximiliano");
        person.setLastName("Ramos Gil");
        person.setDni("74140394");
        person.setEmail("jhianpol.ramos@vallegrande.edu.pe");
        person.setTelephone("974862031");
        person.setTypeCustomer("PERSON");
        person.setTypeProfile("PERSONAL");
        list = Flux.just(person);
    }

    @Nested
    @DisplayName("CRUD")
    public class crud {

        @Test
        @DisplayName("LIST")
        void findAll(){
            when(personRepository.findAll()).thenReturn(list);
            System.out.println("LIST = " + person);
            assertNotEquals(null, list);
        }

        @Test
        @DisplayName("SAVE")
        void save(){
            personRepository.save(person);
            System.out.println("SAVE = " + person);
            assertNotEquals(null, list);
        }

        @Test
        @DisplayName("UPDATE")
        void update(){
            System.out.println("LISTA ORIGINAL = " + person);
            person.setName("BRODA YEICO");
            personRepository.save(person);
            System.out.println("LIST UPDATE = " + person);
            assertNotNull(person.getName());
        }

        @Test
        @DisplayName("DELETE")
        void delete(){
            update();
            personRepository.deleteById(person.getId());
            Mono<Person> person2 = personRepository.findById(person.getId());
            System.out.println("DELETE BY ID = " + person.getId());
            System.out.println("DELETE = " + person);
            assertEquals(null, person2);
        }


    }

    @AfterAll
    void end() {
        System.out.println("END OF TESTS");
    }

}