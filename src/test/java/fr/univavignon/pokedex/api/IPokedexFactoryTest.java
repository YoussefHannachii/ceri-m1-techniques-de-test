package fr.univavignon.pokedex.api;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IPokedexFactoryTest {

    @Mock
    IPokemonFactory pokemonFactory;

    @Mock
    IPokemonMetadataProvider metadataProvider;

    @Mock
    IPokedexFactory pokedexFactory;

    @Test
    void testCreatePokedex() {
        IPokedex expectedPokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(expectedPokedex);
        IPokedex actualPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        verify(pokedexFactory).createPokedex(metadataProvider, pokemonFactory);
        assertEquals(expectedPokedex, actualPokedex);
    }

}
