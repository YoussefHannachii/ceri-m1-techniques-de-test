package fr.univavignon.pokedex.api.implementation;

import fr.univavignon.pokedex.api.*;

public class IPokemonTrainerFactoryImpl implements IPokemonTrainerFactory {

    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory);
        return new PokemonTrainer(name,team,pokedex);
    }
}
