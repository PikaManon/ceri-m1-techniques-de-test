package fr.univavignon.pokedex.api;

import java.util.HashMap;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /**
     * HashMap to link the index of the Pokemon with its Metadata.
     */
    private HashMap<Integer, PokemonMetadata> pokemonMetadatas = new HashMap();

    /**
     * Build the hashmap pokemonMetadatas with our examples of PokemonMetadata.
     */
    public PokemonMetadataProvider() {
        PokemonMetadata aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        this.pokemonMetadatas.put(bulbizarreMetadata.getIndex(), bulbizarreMetadata);
        this.pokemonMetadatas.put(aqualiMetadata.getIndex(), aqualiMetadata);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        if (pokemonMetadatas.containsKey(index)) {
            return pokemonMetadatas.get(index);
        } else {
            throw new PokedexException("this pokemon's index doesn't exist");
        }

    }
}
