package fr.univavignon.pokedex.api.implementation;

import fr.univavignon.pokedex.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IPokedexImpl implements IPokedex {

    private List<Pokemon> pokemons;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;

    public IPokedexImpl(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        pokemons = new ArrayList<>();
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.indexOf(pokemon);
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (!pokemons.contains(getPokemon(id)) || id < 0 || id > 151){
            throw new PokedexException("Invalid index");
        }
        return pokemons.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);

        Collections.sort(sortedPokemons, order);

        return sortedPokemons;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index,cp,hp,dust,candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
