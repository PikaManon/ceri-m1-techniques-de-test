package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.HashMap;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{

    private HashMap<Integer, PokemonMetadata> pokemonMetadatas = new HashMap();
    public PokemonMetadataProvider(){
        PokemonMetadata aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre",126,126,90);
        this.pokemonMetadatas.put(bulbizarreMetadata.getIndex(), bulbizarreMetadata);
        this.pokemonMetadatas.put(aqualiMetadata.getIndex(), aqualiMetadata);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(pokemonMetadatas.containsKey(index)){
            return pokemonMetadatas.get(index);
        }
        else{
            throw new PokedexException("this pokemon's index doesn't exist");
        }

    }
}
