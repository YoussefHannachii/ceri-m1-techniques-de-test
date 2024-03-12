package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokedexTest {

    @Mock
    PokemonMetadata pokemonMetadata;

    @Mock
    IPokemonFactory pokemonFactory;

    @Mock
    IPokedex pokedex;
    List<Pokemon> pokemons;
    List<Pokemon> sortedByIndexPokemonsList;


    @BeforeEach
    public void setUp() {
        pokemons = new ArrayList<Pokemon>();
        when(pokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(new Pokemon(0,"bulbizarre",126,126,90,613,64,4000,4,56));
        when(pokemonFactory.createPokemon(133,2729,202,5000,4)).thenReturn(new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100));
        Pokemon pokemon1 = pokemonFactory.createPokemon(0,613,64,4000,4);
        Pokemon pokemon2 = pokemonFactory.createPokemon(133,2729,202,5000,4);
        pokemons.add(pokemon1);
        pokemons.add(pokemon2);
        sortedByIndexPokemonsList = pokemons;
        sortedByIndexPokemonsList.sort(PokemonComparators.INDEX);
    }

    @Test
    public void addPokemonToTheList() throws PokedexException {
        int index = pokedex.addPokemon(pokemons.get(0));
        when(pokedex.getPokemon(0)).thenReturn(pokemons.get(0));
        Pokemon retrievedPokemon = pokedex.getPokemon(index);
        assertEquals(pokemons.get(0), retrievedPokemon);
    }

    @Test
    public void testGetPokemons() {
        when(pokedex.getPokemons()).thenReturn(pokemons);
        List<Pokemon> actualPokemons = pokedex.getPokemons();
        assertEquals(pokemons.size(), actualPokemons.size());
        assertTrue(actualPokemons.containsAll(pokemons));
    }

    @Test
    public void testGetPokemonsWithIndexSorting() {
        when(pokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(sortedByIndexPokemonsList);
        List<Pokemon> actualPokemons = pokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(sortedByIndexPokemonsList.size(), actualPokemons.size());
        assertTrue(actualPokemons.get(0).getIndex() < actualPokemons.get(1).getIndex());
    }

}
