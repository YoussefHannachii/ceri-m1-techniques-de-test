package fr.univavignon.pokedex.api.implementation;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.util.ArrayList;
import java.util.List;

public class IPokemonMetadataProviderImpl implements IPokemonMetadataProvider {

    List<PokemonMetadata> pokemonsMetadata = new ArrayList<>();

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!pokemonsMetadata.contains(getPokemonMetadata(index)) || index < 0 || index > 151){
            throw new PokedexException("Invalid index");
        }
        return pokemonsMetadata.get(index);
    }
}
