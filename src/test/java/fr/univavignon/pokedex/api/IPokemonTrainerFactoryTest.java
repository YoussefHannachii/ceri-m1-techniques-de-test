package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonTrainerFactoryTest {
    @Mock
    IPokemonTrainerFactory pokemonTrainerFactory;

    @Mock
    IPokedexFactory pokedexFactory;

    @Mock
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Mock
    IPokemonFactory pokemonFactory;


    @Test
    public void creationOfTrainer(){

        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory);

        PokemonTrainer expectedTrainer = new PokemonTrainer("Ash", Team.MYSTIC, pokedex);

        // Define the behavior of the mock
        when(pokemonTrainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory))
                .thenReturn(expectedTrainer);

        // Perform the test
        PokemonTrainer actualTrainer = pokemonTrainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);

        // Verify that the method was called with the expected arguments
        verify(pokemonTrainerFactory).createTrainer("Ash", Team.MYSTIC, pokedexFactory);

        // Verify that the returned trainer is the expected trainer
        assertEquals(expectedTrainer, actualTrainer);
    }
}
