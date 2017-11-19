/**
 * Created by Ranjani on 7/31/2016.
 * The purpose of this class is to lease, evict , check vacancy and calculate rent and income for Apartment
 * This class implements the abstract methods in the parent class Building and interface Rentable
 */
public class KesavanRanjaniApartment extends Building implements Rentable
{
    public KesavanRanjaniApartment()
    {
        this(0);
    }

    public KesavanRanjaniApartment(int num_occupants)
    {
        super(num_occupants); //call the super class constructor to initialize occupants
        max_occupancy = 20;
        upkeep_cost = 3000;
        rent = 950;
    }

    public boolean noVacancy() //returns true if there is no vacancy
    {
        if (getVacancy() == 0)
            return true;
        else
            return false;
    }

    public int getIncome()
    {
        return (collectRent() - upkeep_cost);
    }

    public void onLease(int num_occupants)
    {
        if (!noVacancy()) //check if there is vacancy
            if((occupants + num_occupants) <= max_occupancy) // check if adding occupants will not exceed maximum allowed occupants
                occupants = occupants + num_occupants;

    }

    public void onEviction(int num_occupants)
    {
        if((occupants > 0) && (occupants - num_occupants >= 0)) //check if there are any occupants and ensure occupants does not become a negative number
            occupants = occupants - num_occupants;
    }

    public int collectRent()
    {
        return(occupants * rent);
    }
}
