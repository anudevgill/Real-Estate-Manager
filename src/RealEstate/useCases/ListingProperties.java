package RealEstate.useCases;

import RealEstate.entities.ListingContainer;
import RealEstate.entities.Listing;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.function.Predicate;


public class ListingProperties {

    private final ListingContainer<Integer, Listing> listingContainer;

    /**
     * Create a ListingProperties class
     *
     * @param listingContainer ListingContainer class
     */
    public ListingProperties(ListingContainer<Integer, Listing> listingContainer) {
        this.listingContainer = listingContainer;
    }

    // TODO: Finish Javadoc for SearchByProperty()

    /**
     * Search Listings that are not sold
     *
     * @param property
     * @return ArrayList of String containing the String representation of the Listing
     */
    private ArrayList<String> SearchByProperty(Predicate<Listing> property) {
        ArrayList<String> listings = new ArrayList<>();

        for (Listing listing : listingContainer.values()) {
            if (property.test(listing) && !listing.getIsSold()) {
                listings.add(listing.toString());
            }
        }
        return listings;
    }

    /**
     * Search Listings by Street Name
     *
     * @param streetName Street name to search
     * @return ArrayList of Strings containing the String representation of the Listing
     */
    public ArrayList<String> SearchByStreetName(String streetName) {
        Predicate<Listing> property = (listing) -> listing.getStreetName().equals(streetName);
        return SearchByProperty(property);
    }

    /**
     * Search Listing by civic address
     *
     * @param civicAdress civic address to search
     * @return ArrayList of Strings containing the String representation of the Listing
     */
    public ArrayList<String> SearchByCivicAddress(int civicAdress) {
        Predicate<Listing> property = (listing) -> listing.getCivicAddress() == civicAdress;
        return SearchByProperty(property);
    }

    /**
     * Search Listing by City
     *
     * @param city Coty to Search
     * @return ArrayList of Strings containing the String representation of the Listing
     */
    public ArrayList<String> SearchByCity(String city) {
        Predicate<Listing> property = (listing) -> listing.getCity().equals(city);
        return SearchByProperty(property);
    }

    /**
     * Search Listing by number of bedrooms
     *
     * @param bedrooms Number of Bedrooms
     * @return ArrayList of Strings containing the String representation of the Listing
     */
    public ArrayList<String> SearchByBedrooms(int bedrooms) {
        Predicate<Listing> property = (listing) -> listing.getBedrooms() == bedrooms;
        return SearchByProperty(property);
    }

    /**
     * Search Listing by number of Bathroom
     *
     * @param bathrooms Number of Bathrooms
     * @return ArrayList of Strings containing the String representation of the Listing
     */
    public ArrayList<String> SearchByBathrooms(int bathrooms) {
        Predicate<Listing> property = (listing) -> listing.getBathrooms() == bathrooms;
        return SearchByProperty(property);
    }

    /**
     * Search Listing by number of floors
     *
     * @param floors Number of floors
     * @return ArrayList of Strings containing the String representation of the Listing
     */
    public ArrayList<String> SearchByFloors(int floors) {
        Predicate<Listing> property = (listing) -> listing.getFloors() == floors;
        return SearchByProperty(property);
    }

    /**
     * Search Listing by Price
     *
     * @param upperLimit Upper limit of the price
     * @param lowerLimit Lower limit of the price
     * @return ArrayList of Strings containing the String representation of the Listing
     */
    public ArrayList<String> SearchByPrice(BigDecimal upperLimit, BigDecimal lowerLimit) {
        Predicate<Listing> property = (listing) -> upperLimit.compareTo(listing.getPrice()) >= 0 && lowerLimit.compareTo(listing.getPrice()) <= 0;
        return SearchByProperty(property);
    }

    /**
     * Search Listing by type of property
     *
     * @param type Type of the property
     * @return ArrayList of Strings containing the String representation of the Listing
     */
    public ArrayList<String> SearchByListingType(String type) {
        Predicate<Listing> property = (listing) -> listing.getType().equals(type);
        return SearchByProperty(property);
    }
}
