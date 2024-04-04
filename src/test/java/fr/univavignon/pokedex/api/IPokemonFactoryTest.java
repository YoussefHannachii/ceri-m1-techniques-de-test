package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonFactoryTest {

    @Mock
    IPokemonFactory pokemonFactory;

    @Test
    public void pokemonCreationTest() throws PokedexException {

        int index = 133;
        int cp = 2729;
        int hp = 202;
        int dust = 5000;
        int candy = 4;

        Pokemon expectedPokemon = new Pokemon(index, "", 0, 0, 0, cp, hp, dust, candy, 0.0);
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(expectedPokemon);
        assertEquals(pokemonFactory.createPokemon(index, cp, hp, dust, candy),expectedPokemon);
    }


}
