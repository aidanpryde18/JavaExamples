/**
 * Created by Billy on 9/7/2016.
 */
public class Search {

    public int binarySearch(Comparable[] objArray, Comparable searchObj)
    {
        int low = 0;

        int high = objArray.length - 1;

        int mid = 0;

        if (objArray.length == 0)
        {
            return 0;
        }

        if (objArray[low].compareTo(searchObj) >= 0)
        {
            return low;
        }
        else if (objArray[high].compareTo(searchObj) <= 0)
        {
            return high;
        }

        while (low <= high)
        {
            mid = (low + high) / 2;

            if (objArray[mid].compareTo(searchObj) < 0)
            {
                low = mid + 1;
                if (objArray[low].compareTo(searchObj) > 0)
                {
                    return low;
                }
            }
            else if (objArray[mid].compareTo(searchObj) > 0)
            {
                high = mid - 1;
                if (objArray[mid].compareTo(searchObj) < 0)
                {
                    return high;
                }
            }
            else
            {
                return mid;
            }
        }

        return -1;
    }
}
