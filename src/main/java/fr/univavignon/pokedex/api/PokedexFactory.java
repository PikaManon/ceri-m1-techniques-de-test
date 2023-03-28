package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory{
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {

        IPokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);


        return pokedex;
    }

}
