/**
 * Created by Ranjani on 7/31/2016.
 * The purpose of this class is to lease, evict , check vacancy and calculate rent and income for duplex
 * This class implements the abstract methods in the parent class Building and interface Rentable
 */
public class KesavanRanjaniDuplex extends Building implements Rentable
{

    public KesavanRanjaniDuplex()
    {
        this(0);
    }
    public KesavanRanjaniDuplex(int num_occupants)
    {
        super(num_occupants); //call the super class constructor to initialize occupants
        max_occupancy = 6;
        upkeep_cost = 1500;
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
        if(num_occupants == 3) //check if the number of occupants to be leased is 3
        {
            if (!noVacancy() && (occupants + 3 <= max_occupancy)) // check if there is vacancy and if adding occupants will not exceed maximum allowed occupants
                occupants = occupants + 3;
        }
        else
                System.out.println("Number of occupants must be 3");
    }

    public void onEviction(int num_occupants)
    {

        if (num_occupants ==3) //evict only if the number of occupants to be evicted is 3
        {
                if (occupants > 0) //check if there are any occupants
                    occupants = occupants - 3;
        }
        else
                System.out.println("Number of occupants evicted must be 3");
    }

    public int collectRent()
    {
        int total_rent = 0;
       if(occupants > 0 && occupants <= 3) //if number of occupants is upto 3
           total_rent = rent;
        else if(occupants > 3)
           total_rent = rent * 2; //double the rent if more than 3 occupants
        return total_rent;
    }
}
