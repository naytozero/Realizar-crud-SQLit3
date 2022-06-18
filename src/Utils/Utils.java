
package Utils;


import java.util.Date;

public class Utils {

    public String generaIds(){

        Date date = new Date();
        String id;
        id=""+date.getTime(); 

        return id;


    }

}