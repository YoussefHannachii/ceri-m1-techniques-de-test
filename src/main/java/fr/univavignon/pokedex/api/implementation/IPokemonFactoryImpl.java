package fr.univavignon.pokedex.api.implementation;

import fr.univavignon.pokedex.api.*;

public class IPokemonFactoryImpl implements IPokemonFactory {

    private IPokemonMetadataProvider pokemonMetadataProvider = new IPokemonMetadataProviderImpl();

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
        double iv = (double) (pokemonMetadata.getAttack() + pokemonMetadata.getDefense() + pokemonMetadata.getStamina()) / 45*100;
        return new Pokemon(pokemonMetadata.getIndex(),
                pokemonMetadata.getName(),
                pokemonMetadata.getAttack(),
                pokemonMetadata.getDefense(),
                pokemonMetadata.getStamina(),
                cp,hp,dust,candy,iv);
    }
}
