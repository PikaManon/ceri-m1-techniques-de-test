package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    List<Pokemon> capturedPokemon = new ArrayList<>();
    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;

    public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory){
        this.pokemonFactory = pokemonFactory;
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }


    @Override
    public int size() {
        return capturedPokemon.size();
    }
    @Override
    public int addPokemon(Pokemon pokemon) {
        capturedPokemon.add(pokemon);
        return capturedPokemon.size()-1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= capturedPokemon.size()){
            throw new PokedexException("this pokemon's index doesn't exist");
        }
        else{
            return capturedPokemon.get(id);
        }
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(capturedPokemon);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        capturedPokemon.sort(order);
        List<Pokemon> unmodifiableCapturedPokemon = Collections.unmodifiableList(capturedPokemon);
        return unmodifiableCapturedPokemon;
    }


    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        //return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        return null;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
